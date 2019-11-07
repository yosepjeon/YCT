package io.yosep.agile.project.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import io.yosep.agile.project.model.dto.ProjectDTO;

public interface ProjectService {
	// 01. 프로젝트 목록
	public List<ProjectDTO> projectList() throws Exception;
	
	// 02. 프로젝트 생성
	public void createProject(ProjectDTO projectDTO,MultipartHttpServletRequest mtfRequest,HttpSession session) throws Exception;
	
	// 03. 프로젝트 상세보기
	public ProjectDTO viewProject(ProjectDTO projectDTO) throws Exception;
	
	// 04. 프로젝트 삭제하기
	public void deleteProject(String projectId) throws Exception;
	
	// 05. 프로젝트 정보 수정
	public void updateProject(ProjectDTO projectDTO) throws Exception;
	
	// 06. 나의 소속 프로젝트 목록
	public List<ProjectDTO> myOwnProjectList(String userId);
	
	// 07. 프로젝트에 소속된 유저 목록
	public List<String> usersInTheProject(String projectId);
}
