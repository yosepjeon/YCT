package io.yosep.agile.dashboard.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.yosep.agile.dashboard.model.dto.DashBoardDTO;
import io.yosep.agile.dashboard.service.DashBoardService;
import io.yosep.agile.scheduler.Scheduler;

// 2019년 06월 11일
// 작성자: 전요셉
@Controller
@RequestMapping(value="/dashboard")
public class DashBoardController {
	private static final Logger logger = LoggerFactory.getLogger(DashBoardController.class);
	public static Map<String, Object> weatherMap;
	@Autowired
	DashBoardService dashBoardService;
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public ModelAndView goMain(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		DashBoardDTO dashBoardDTO = new DashBoardDTO();
		dashBoardService.getDashBoardElements(null,dashBoardDTO, session);
		weatherMap = Scheduler.data;
		if(weatherMap == null) {
			System.out.println("weather is Null");
			weatherMap = getWeathers();
		}
		ObjectMapper mapper = new ObjectMapper();
		
//		mav.addObject("city",weatherMap.get(""));
		mav.addObject("weather",weatherMap);
		mav.addObject("elements",dashBoardDTO);
		mav.setViewName("/dashboard/index");
		
		return mav;
	}
	
	public Map<String,Object> getWeathers() {
		Map<String,Object> data;
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
			
			// 문자열을 JSON으로 파싱
			ObjectMapper mapper = new ObjectMapper();
			data = mapper.readValue(new URL(urlstr), new TypeReference<Map<String,Object>>() {});
			
			return data;
		} catch (Exception e) {
			return null;
		}
	}
}
