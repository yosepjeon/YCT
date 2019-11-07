package io.yosep.agile.sprint.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.yosep.agile.sprint.domain.dto.SprintDTO;
import io.yosep.agile.sprint.service.SprintService;
import io.yosep.agile.util.TimeUtils;

@Controller
@RequestMapping(value="/sprint")
public class SprintController {
	@Autowired
	SprintService sprintService;
	
	@RequestMapping(value="/createSprint",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> createSprint(@RequestBody Map<String,Object> sprintJson,HttpSession session) throws Exception {
		Map<String, Object> resultJson = new HashMap<String, Object>();
		@SuppressWarnings("unchecked")
		List<SprintDTO> sprintList = (List<SprintDTO>)session.getAttribute("sprintList");
		
		SprintDTO sprintDTO = new SprintDTO();
		sprintDTO.setSprintId((String)sprintJson.get("sprintId"));
		sprintDTO.setProjectId((String)sprintJson.get("projectId"));
		sprintDTO.setSprintName((String)sprintJson.get("sprintName"));
		sprintDTO.setDescription((String)sprintJson.get("description"));
		sprintDTO.setState((String)sprintJson.get("state"));
		
//		System.out.println("year: " + String.valueOf(sprintJson.get("year")));
//		System.out.println("month: " + String.valueOf(sprintJson.get("month")));
		sprintDTO.setStartDate(TimeUtils.getStartTime(Integer.valueOf(String.valueOf(sprintJson.get("startYear"))),
				Integer.valueOf(String.valueOf(sprintJson.get("startMonth"))),
				Integer.valueOf(String.valueOf(sprintJson.get("startDay"))),
				Integer.valueOf(String.valueOf(sprintJson.get("startHour"))),
				Integer.valueOf(String.valueOf(sprintJson.get("startMin"))),
				Integer.valueOf(String.valueOf(sprintJson.get("startSecond")))));
		sprintDTO.setEndDate(TimeUtils.getDefaultEndTime(Integer.valueOf(String.valueOf(sprintJson.get("endYear"))),
				Integer.valueOf(String.valueOf(sprintJson.get("endMonth"))),
				Integer.valueOf(String.valueOf(sprintJson.get("endDay"))),
				Integer.valueOf(String.valueOf(sprintJson.get("endHour"))),
				Integer.valueOf(String.valueOf(sprintJson.get("endMin"))),
				Integer.valueOf(String.valueOf(sprintJson.get("endSecond")))));
		
		sprintService.createSprint(sprintDTO, session);
		sprintList.add(sprintDTO);
		session.setAttribute("sprintList", sprintList);
		session.setAttribute("sprintListSize", sprintList.size());
		
		resultJson.put("sprintId", sprintDTO.getSprintId());
		resultJson.put("projectId", sprintDTO.getProjectId());
		resultJson.put("sprintName", sprintDTO.getSprintName());
		resultJson.put("description", sprintDTO.getDescription());
		resultJson.put("state", sprintDTO.getState());
		resultJson.put("startDate", sprintDTO.getStartDate());
		resultJson.put("endDate", sprintDTO.getEndDate());
		
		return resultJson;
	}
	
	@RequestMapping(value="/deleteSprint", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> deleteSprint(@RequestBody Map<String,Object> sprintData,HttpSession session) throws Exception {
		Map<String, Object> resultJson = new HashMap<>();
		String sprintId = String.valueOf(sprintData.get("sprintId"));
		boolean isSuccess = false;
		
		resultJson.put("deleteSuccess", sprintService.deleteSprint(sprintId, session) == 1 ? true:false);
		return resultJson;
	}
	
	@RequestMapping(value="/viewSprint", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> viewSprint(@RequestParam("sprintId") String sprintId, HttpSession session) throws Exception {
		Map<String, Object> resultJson = new HashMap<>();
		SprintDTO sprint = sprintService.viewSprint(sprintId);
		resultJson.put("sprintName", sprint.getSprintName());
		resultJson.put("startDate", sprint.getStartDate());
		resultJson.put("endDate", sprint.getEndDate());
		
		return resultJson;
	}
	
	@RequestMapping(value="/startSprint")
	public @ResponseBody Map<String, Object> viewSprint(@RequestBody Map<String,Object> sprintData, HttpSession session) throws Exception {
		Map<String, Object> resultJson = new HashMap<>();
		boolean result = sprintService.startSprint((String)sprintData.get("sprintId"), (String)sprintData.get("projectId"));
		
		resultJson.put("startResult", result);
		return resultJson;
	}
	
	// 해야할 것 -> 스프린트 숫자 다시 코딩...
}
