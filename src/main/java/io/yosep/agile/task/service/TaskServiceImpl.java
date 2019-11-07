package io.yosep.agile.task.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import io.yosep.agile.task.domain.dao.TaskDAO;
import io.yosep.agile.task.domain.dto.TaskDTO;
import io.yosep.agile.task.domain.dto.TaskFileDTO;
import io.yosep.agile.task.domain.dto.TaskUserDTO;
import io.yosep.agile.util.TaskUploadFileUtil;

@Service
public class TaskServiceImpl implements TaskService{
	@Autowired
	TaskDAO taskDAO;
	
	@Override
	public List<TaskDTO> taskList(String projectId) throws Exception {
		// TODO Auto-generated method stub
		return taskDAO.taskList(projectId);
	}

	@Transactional
	@Override
	public void createTask(TaskDTO taskDTO, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		String userId = (String) session.getAttribute("userId");
		TaskUserDTO taskUserDTO = new TaskUserDTO();
		boolean hasUploadFiles = false;
		
		TaskFileDTO[] taskFileDTO = new TaskFileDTO[taskDTO.getAttachments().size()];
		
		hasUploadFiles = TaskUploadFileUtil.makeFirstTaskFile(taskDTO, taskFileDTO);
		System.out.println(taskDTO.getTaskPriority() + "@@@");
		taskDAO.createTask(taskDTO);
		
		if(hasUploadFiles) {
			taskDAO.createTaskFile(taskFileDTO);
		}
		
		taskUserDTO.setUserId(userId);
		taskUserDTO.setTaskId(taskDTO.getTaskId());
		
		taskDAO.insertUserToTask(taskUserDTO);
	}

	@Override
	public TaskDTO viewTask(String taskId) throws Exception {
		// TODO Auto-generated method stub
		return taskDAO.getTask(taskId);
	}

	@Override
	public int deleteTask(String taskId) throws Exception {
		// TODO Auto-generated method stub
		return taskDAO.deleteTask(taskId);
	}

	@Override
	public int updateTask(TaskDTO taskDTO) throws Exception {
		// TODO Auto-generated method stub
		return taskDAO.updateTask(taskDTO);
	}

	@Override
	public int taskCount(String projectId) throws Exception {
		// TODO Auto-generated method stub
		return taskDAO.getTaskCount(projectId);
	}

	@Override
	public List<TaskDTO> taskListInSprint(String sprintId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskDTO> getTaskByStatus(String sprintId, String status) {
		// TODO Auto-generated method stub
		return taskDAO.getTaskByStatus(sprintId,status);
	}

}
