package io.yosep.agile.scheduler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.xdevapi.JsonArray;

import io.yosep.agile.project.model.dao.ProjectDAO;
import io.yosep.agile.sprint.domain.dao.SprintDAO;
import io.yosep.agile.task.domain.dao.TaskDAO;
import io.yosep.agile.util.Weather;

@Component
public class Scheduler {
	@Autowired
	ProjectDAO projectDAO;
	@Autowired
	SprintDAO sprintDAO;
	@Autowired
	TaskDAO taskDAO;
	
	public static Map<String, Object> data;

	@Scheduled(cron = "0 0 0/1 * * *")
	public void getWeather() {
		try {
//			String urlstr = "https://api.openweathermap.org/data/2.5/weather?q=seoul,kor&appid=c0e1d92f6554da67cef768004248f46c";
			String urlstr = "https://api.openweathermap.org/data/2.5/forecast?q=seoul,kor&appid=c0e1d92f6554da67cef768004248f46c";
			URL url = new URL(urlstr);
			BufferedReader bf;
			String line;
			String result = "";
			
			// 날씨 정보를 받아온다.
			bf = new BufferedReader(new InputStreamReader(url.openStream()));
			
			// 버퍼에 있는 정보를 문자열로 변환
			while((line=bf.readLine())!= null) {
				result = result.concat(line);
			}
			System.out.println("@@@");
			// 문자열을 JSON으로 파싱
			ObjectMapper mapper = new ObjectMapper();
			data = mapper.readValue(new URL(urlstr), new TypeReference<Map<String,Object>>() {});
			
			System.out.println(data);
		} catch (Exception e) {

		}
	}

	@Scheduled(cron = "5 * * * * *")
	@Transactional
	public void deleteExpiredSprint() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar time = Calendar.getInstance();

		String timeFormat = sdf.format(time.getTime());
		System.out.println("시간: " + timeFormat);

		List<String> sprintIds = sprintDAO.getExpiredSprint(timeFormat);
		System.out.println("사이즈: " + sprintIds.size());

		List<String> taskIds = new ArrayList<String>();
		for (String sprintId : sprintIds) {
			List<String> subTaskIds = taskDAO.getNotProcessTaskFromExpiredSprint(sprintId);
			System.out.println("서브테스크 사이즈: " + subTaskIds.size());
			for (String subTaskId : subTaskIds) {
				taskIds.add(subTaskId);
			}
		}

		for (String taskId : taskIds) {
			taskDAO.changeExpiredSprintToDefaultSprint(taskId);
		}

		for (String sprintId : sprintIds) {
			sprintDAO.deleteSprint(sprintId);
		}

		System.out.println("schedule done!!!");
	}
}
