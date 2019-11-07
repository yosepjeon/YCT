package io.yosep.agile.task.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import io.yosep.agile.task.domain.dto.TaskDTO;

public interface TaskService {
	// 01. 테스크 목록
	public List<TaskDTO> taskList(String projectId) throws Exception;
	
	// 02. 테스크 생성
	public void createTask(TaskDTO taskDTO, HttpSession session) throws Exception;
	
	// 03. 테스크 상세보기
	public TaskDTO viewTask(String taskId) throws Exception;
	
	// 04. 테스크 삭제하기
	public int deleteTask(String taskId) throws Exception;
	
	// 05. 테스크 정보 수정
	public int updateTask(TaskDTO taskDTO) throws Exception;
	
	// 06. 나의 테스크 갯수
	public int taskCount(String projectId) throws Exception;
	
	// 07. 스프린트 내의 테스크 가져오기
	public List<TaskDTO> taskListInSprint(String sprintId);
	
	public List<TaskDTO> getTaskByStatus(String sprintId, String status);
}
