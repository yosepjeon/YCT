package io.yosep.agile.task.domain.dao;

import java.util.List;

import io.yosep.agile.task.domain.dto.TaskDTO;
import io.yosep.agile.task.domain.dto.TaskFileDTO;
import io.yosep.agile.task.domain.dto.TaskUserDTO;

public interface TaskDAO {
	// 01. 테스크 목록 가져오기
	public List<TaskDTO> taskList(String projectId);
	
	// 02. 테스크 갯수 가져오기
	public int getTaskCount(String projectId);
	
	// 03. 테스크 생성
	public void createTask(TaskDTO taskDTO);
	
	// 04. 테스크 삭제
	public int deleteTask(String taskId);
	
	// 05. 테스크 수정
	public int updateTask(TaskDTO taskDTO);
	
	// 06. 스프린트 내의 테스크 갯수 가져오기
	public int getTaskCountInSprint(String sprintId);
	
	// 07. 테스크 파일업로드
	public void createTaskFile(TaskFileDTO[] taskFileDTO);
	
	// 08. 해당 테스크에 멤버 할당하기
	public void insertUserToTask(TaskUserDTO taskUserDTO);
	
	public TaskDTO getTask(String taskId);
	
	public List<TaskDTO> getTaskByStatus(String sprintId,String status);
	
	// 테스크를 드래그해서 옮길때 실시간으로 상태 업데이터
	public void updateRealTimeTask(TaskDTO taskDTO);
	
	
	// 만료된 스프린트 내에서 아직 done이 되지 않은 테스크들 가져오기
	public List<String> getNotProcessTaskFromExpiredSprint(String sprintId);
	
	// 만료된 스프린트 내에서 아직 done이 되지 않은 테스크들 sprint#으로 보내서 다음 스프린트에서 처리하도록
	public void changeExpiredSprintToDefaultSprint(String taskId);
}
