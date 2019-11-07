package io.yosep.agile.project.model.dao;

import java.util.List;

import io.yosep.agile.project.model.dto.ProjectDTO;
import io.yosep.agile.project.model.dto.ProjectFileDTO;
import io.yosep.agile.project.model.dto.ProjectUserDTO;
import io.yosep.agile.user.model.dto.UserDTO;

public interface ProjectDAO {
	// 01. 프로젝트 목록
	public List<ProjectDTO> projectList();
	
	// 02. 프로젝트 생성
	public void createProject(ProjectDTO projectDTO);
	
	// 03. 프로젝트 상세보기
	public ProjectDTO viewProject(ProjectDTO projectDTO);
	
	// 04. 프로젝트 삭제하기
	public void deleteProject(String projectId);
	
	// 05. 프로젝트 정보 수정
	public void updateProject(ProjectDTO projectDTO);
	
	// 06. 프로젝트 파일업로드
	public void createProjectFile(ProjectFileDTO[] projectFileDTO);
	
	// 07. 본인소속 프로젝트 목록
	public List<ProjectDTO> myOwnProjectList(String userId);
	
	// 08. 해당 프로젝트에 멤버 참여시키기
	public void insertUserToProject(ProjectUserDTO projectUserDTO);
	
	// 09. 해당 프로젝트의 소속된 멤버들 불러오기
	public List<String> usersInTheProject(String projectId);
}
