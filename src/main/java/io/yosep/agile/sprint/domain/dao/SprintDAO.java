package io.yosep.agile.sprint.domain.dao;

import java.util.List;

import io.yosep.agile.sprint.domain.dto.SprintDTO;

public interface SprintDAO {
	// 01. 스프린트 목록 가져오기
	public List<SprintDTO> sprintList(String projectId);
	
	// 02. 스프린트 갯수 가져오기
	public int getSprintCount(String projectId);
	
	// 스프린트 상세보기
	public SprintDTO viewSprint(String sprintId);
	
	// 03. 스프린트 생성
	public void createSprint(SprintDTO sprintDTO);
	
	// 04. 스프린트 삭제
	public int deleteSprint(String sprintId);
	
	// 05. 스프린트 시작
	public boolean startSprint(String sprintId,String projectId);
	
	// 현재 시작중인 스프린트에 대한 내용 가져오기
	public SprintDTO getStartSprint(String projectId);
	
	// 스케줄 발동시 만료된 스프린트 가져오기
	public List<String> getExpiredSprint(String time);
}
