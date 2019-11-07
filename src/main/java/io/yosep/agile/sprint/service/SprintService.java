package io.yosep.agile.sprint.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import io.yosep.agile.sprint.domain.dto.SprintDTO;

public interface SprintService {
	// 01. 스프린트 목록
	public List<SprintDTO> sprintList(String projectId) throws Exception;
	
	// 02. 스프린트 갯수
	public int sprintCount(String projectId) throws Exception;
	
	// 03. 스프린트 생성
	public void createSprint(SprintDTO sprintDTO,HttpSession session) throws Exception;
	
	// 04. 스프린트 삭제
	public int deleteSprint(String sprintId,HttpSession session) throws Exception;
	
	// 05. 스프린트 시작
	public boolean startSprint(String sprintId,String projectId) throws Exception;
	
	public SprintDTO viewSprint(String sprintId) throws Exception;
	
	// 시작중인 스프린트 내용 가져오기
	public SprintDTO getStartSprint(String projectId);
}
