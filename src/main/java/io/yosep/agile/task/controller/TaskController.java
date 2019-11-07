package io.yosep.agile.task.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import io.yosep.agile.project.service.ProjectService;
import io.yosep.agile.sprint.domain.dto.SprintDTO;
import io.yosep.agile.sprint.service.SprintService;
import io.yosep.agile.task.domain.dto.TaskDTO;
import io.yosep.agile.task.service.TaskService;
import io.yosep.agile.util.TimeUtils;

@Controller
@RequestMapping(value = "/task")
public class TaskController {
	@Autowired
	TaskService taskService;
	@Autowired
	ProjectService projectService;
	@Autowired
	SprintService sprintService;

	@RequestMapping(value = "/getelement", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getDataForCreateTask(@RequestParam("projectId") String projectId,
			HttpSession session) throws Exception {
		Map<String, Object> resultJson = new HashMap<String, Object>();
		List<String> userList = null;
		List<SprintDTO> sprintList = null;

		userList = projectService.usersInTheProject(projectId);
		sprintList = sprintService.sprintList(projectId);

		resultJson.put("userList", userList);
		resultJson.put("sprintList", sprintList);
		return resultJson;
	}

	@RequestMapping(value = "/createTask", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> createTask(@RequestParam("taskId") String taskId,
			@RequestParam("taskName") String taskName, @RequestParam("description") String description,
			MultipartHttpServletRequest mtfRequest, @RequestParam("taskStatus") String taskStatus,
			@RequestParam("taskPriority") String taskPriority, @RequestParam("assignee") String assignee,
			@RequestParam("projectId") String projectId, @RequestParam("sprintId") String sprintId,
			@RequestParam("year") Object year, @RequestParam("month") Object month, @RequestParam("day") Object day,
			@RequestParam("hour") Object hour, @RequestParam("min") Object min, @RequestParam("second") Object second,
			HttpSession session) throws Exception {
		Map<String, Object> resultJson = new HashMap<>();

		List<TaskDTO> taskList = new ArrayList<>();
		List<MultipartFile> attachments = mtfRequest.getFiles("attachments");

		TaskDTO taskDTO = new TaskDTO();
//
//		System.out.println(taskId + "%%%");
//		System.out.println(sprintId);
//		System.out.println(sprintId.equals(""));

		taskDTO.setTaskId(taskId);
		taskDTO.setTaskName(taskName);
		taskDTO.setDescription(description);
		taskDTO.setAttachments(attachments);
		taskDTO.setTaskStatus(taskStatus);
		taskDTO.setTaskPriority(taskPriority);
		taskDTO.setAssignee(assignee);
		taskDTO.setSprintId(sprintId);
		taskDTO.setProjectId(projectId);
		taskDTO.setReporter((String) session.getAttribute("userName"));
		taskDTO.setStartDate(
				TimeUtils.getStartTime(Integer.valueOf(String.valueOf(year)), Integer.valueOf(String.valueOf(month)),
						Integer.valueOf(String.valueOf(day)), Integer.valueOf(String.valueOf(hour)),
						Integer.valueOf(String.valueOf(min)), Integer.valueOf(String.valueOf(second))));
		taskDTO.setEndDate(TimeUtils.getDefaultEndTime(Integer.valueOf(String.valueOf(year)),
				Integer.valueOf(String.valueOf(month)), Integer.valueOf(String.valueOf(day)),
				Integer.valueOf(String.valueOf(hour)), Integer.valueOf(String.valueOf(min)),
				Integer.valueOf(String.valueOf(second))));

		taskService.createTask(taskDTO, session);
		taskList.add(taskDTO);

		resultJson.put("sprintId", sprintId);
		resultJson.put("taskId", taskDTO.getTaskId());
		resultJson.put("taskName", taskDTO.getTaskName());
		resultJson.put("taskPriority", taskDTO.getTaskPriority());

		return resultJson;
	}

	@RequestMapping(value = "/deleteTask", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> deleteTask(@RequestBody Map<String,Object> taskData) throws Exception {
		Map<String, Object> resultJson = new HashMap<>();
		String taskId = String.valueOf(taskData.get("taskId"));
		boolean isSuccess = false;
//		System.out.println(taskId + "@@@@@");
		
		resultJson.put("deleteSuccess", taskService.deleteTask(taskId) == 1 ? true:false);
		return resultJson;
	}

	@RequestMapping(value = "/updateTask", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> updateTask(@RequestParam("taskId") String taskId,
			@RequestParam("taskName") String taskName, @RequestParam("description") String description,
			MultipartHttpServletRequest mtfRequest, @RequestParam("taskStatus") String taskStatus,
			@RequestParam("taskPriority") String taskPriority, @RequestParam("assignee") String assignee,
			@RequestParam("projectId") String projectId, @RequestParam("sprintId") String sprintId,
			@RequestParam("year") Object year, @RequestParam("month") Object month, @RequestParam("day") Object day,
			@RequestParam("hour") Object hour, @RequestParam("min") Object min, @RequestParam("second") Object second,
			HttpSession session) throws Exception {
		Map<String, Object> resultJson = new HashMap<>();

		List<TaskDTO> taskList = new ArrayList<>();
		List<MultipartFile> attachments = mtfRequest.getFiles("attachments");

		TaskDTO taskDTO = new TaskDTO();

//		System.out.println(taskId + "%%%");
//		System.out.println(sprintId);
//		System.out.println(sprintId.equals(""));

		taskDTO.setTaskId(taskId);
		taskDTO.setTaskName(taskName);
		taskDTO.setDescription(description);
		taskDTO.setAttachments(attachments);
		taskDTO.setTaskStatus(taskStatus);
		taskDTO.setTaskPriority(taskPriority);
		taskDTO.setAssignee(assignee);
		taskDTO.setSprintId(sprintId);
		taskDTO.setProjectId(projectId);
		taskDTO.setReporter((String) session.getAttribute("userName"));
		taskDTO.setStartDate(
				TimeUtils.getStartTime(Integer.valueOf(String.valueOf(year)), Integer.valueOf(String.valueOf(month)),
						Integer.valueOf(String.valueOf(day)), Integer.valueOf(String.valueOf(hour)),
						Integer.valueOf(String.valueOf(min)), Integer.valueOf(String.valueOf(second))));
		taskDTO.setEndDate(TimeUtils.getDefaultEndTime(Integer.valueOf(String.valueOf(year)),
				Integer.valueOf(String.valueOf(month)), Integer.valueOf(String.valueOf(day)),
				Integer.valueOf(String.valueOf(hour)), Integer.valueOf(String.valueOf(min)),
				Integer.valueOf(String.valueOf(second))));

		taskService.updateTask(taskDTO);
//		taskService.createTask(taskDTO, session);
		taskList.add(taskDTO);

		resultJson.put("sprintId", sprintId);
		resultJson.put("taskId", taskDTO.getTaskId());
		resultJson.put("taskName", taskDTO.getTaskName());
		resultJson.put("taskPriority", taskDTO.getTaskPriority());

		return resultJson;
	}

	@RequestMapping(value = "/viewTask", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> viewTask(@RequestParam("taskId") String taskId,
			@RequestParam("projectId") String projectId) throws Exception {
		Map<String, Object> resultJson = new HashMap<>();
		List<String> userList = null;
		List<SprintDTO> sprintList = null;

		userList = projectService.usersInTheProject(projectId);
		sprintList = sprintService.sprintList(projectId);
		TaskDTO taskDTO = taskService.viewTask(taskId);

		resultJson.put("sprintId", taskDTO.getSprintId());
		resultJson.put("taskName", taskDTO.getTaskName());
		resultJson.put("taskPriority", taskDTO.getTaskPriority());
		resultJson.put("taskDescription", taskDTO.getDescription());
		resultJson.put("taskStatus", taskDTO.getTaskStatus());
		resultJson.put("taskId", taskDTO.getTaskId());
		resultJson.put("assignee", taskDTO.getAssignee());
		resultJson.put("userList", userList);
		resultJson.put("sprintList", sprintList);

		return resultJson;
	}
}
