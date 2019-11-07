package io.yosep.agile.project.conroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import io.yosep.agile.dashboard.model.dto.DashBoardDTO;
import io.yosep.agile.dashboard.service.DashBoardService;
import io.yosep.agile.project.model.dto.ProjectDTO;
import io.yosep.agile.project.service.ProjectService;
import io.yosep.agile.sprint.domain.dto.SprintDTO;
import io.yosep.agile.sprint.service.SprintService;
import io.yosep.agile.task.domain.dto.TaskDTO;
import io.yosep.agile.task.service.TaskService;

@Controller
@RequestMapping(value = "/project")
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	@Autowired
	private DashBoardService dashBoardService;
	@Autowired
	private SprintService sprintService;
	@Autowired
	private TaskService taskService;

	// 2019년 06월 13일
	// 작성자: 전요셉
	// 내용: project 생성 컨트롤러
	@RequestMapping(value = "/createProject", method = RequestMethod.POST)
	public ModelAndView createProject(@ModelAttribute ProjectDTO projectDTO, MultipartHttpServletRequest mtfRequest,
			HttpSession session) throws Exception {
		StringBuffer sb = new StringBuffer();
		ModelAndView mav = new ModelAndView();
		projectService.createProject(projectDTO, mtfRequest, session);
		
		sb.append("redirect:/project/viewBackLog/");
		sb.append(projectDTO.getProjectId());
		mav.addObject(projectDTO);

		mav.setViewName(sb.toString());

		return mav;
	}

	// 2019년 06월 13일
	// 작성자: 전요셉
	// 내용: project view 컨트롤러
	@RequestMapping(value = "/viewStartSprint/{projectId}/{sprintId}")
	public ModelAndView viewStartSprint(@PathVariable("projectId") String projectId, @PathVariable("sprintId") String sprintId, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();
		DashBoardDTO dashBoardDTO = new DashBoardDTO();
		StringBuffer sb = new StringBuffer();
		
		dashBoardService.getDashBoardElements(projectId,dashBoardDTO, session);
		List<TaskDTO> todo = taskService.getTaskByStatus(sprintId,"todo");
		List<TaskDTO> inprogress = taskService.getTaskByStatus(sprintId,"inprogress");
		List<TaskDTO> done = taskService.getTaskByStatus(sprintId,"done");
		
		session.setAttribute("sprintId", dashBoardDTO.getStartSprint().getSprintId());
		
		mav.addObject("elements", dashBoardDTO);
		mav.addObject("projectId", projectId);
		mav.addObject("todo", todo);
		mav.addObject("inprogress",inprogress);
		mav.addObject("done",done);
		mav.setViewName("/project/projectView");

		return mav;
	}

	// 2019년 07월 01일
	// 작성자: 전요셉
	// 내용: backlog view 컨트롤러
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/viewBackLog/{projectId}")
	public ModelAndView viewBackLogAndSprint(@PathVariable("projectId") String projectId, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();
		DashBoardDTO dashBoardDTO = new DashBoardDTO();
		List<SprintDTO> sprintList;
		List<TaskDTO> taskList;
		int sprintListSize = 0;
		int taskListSize = 0;

		dashBoardService.getDashBoardElements(projectId,dashBoardDTO, session);
//		if(session.getAttribute("sprintList") == null) {
		sprintList = sprintService.sprintList(projectId);
		taskList = taskService.taskList(projectId);

		sprintListSize = sprintList.size();
		taskListSize = taskList.size();
		session.setAttribute("sprintList", sprintList);
		session.setAttribute("sprintListSize", sprintListSize);
		session.setAttribute("taskList", taskList);
		session.setAttribute("taskListSize", taskListSize);

//		}else {
//			sprintList = (List<SprintDTO>) session.getAttribute("sprintList");
//			sprintListSize = (int)session.getAttribute("sprintListSize");
//		}
		String firstSprint = projectId + "_Sprint#";

		mav.addObject("elements", dashBoardDTO);
		mav.addObject("projectId", projectId);
		mav.addObject("sprintList", sprintList);
		mav.addObject("sprintListSize", sprintListSize);
		mav.addObject("taskList",taskList);
		mav.addObject("taskListSize",taskListSize);
		mav.addObject("firstSprintId",firstSprint);
//		mav.addObject("startSprintId",dashB);
		mav.setViewName("/backlog/backlogView");

		return mav;
	}
}
