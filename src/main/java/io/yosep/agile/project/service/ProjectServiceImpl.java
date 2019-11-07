package io.yosep.agile.project.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import io.yosep.agile.project.model.dao.ProjectDAO;
import io.yosep.agile.project.model.dto.ProjectDTO;
import io.yosep.agile.project.model.dto.ProjectFileDTO;
import io.yosep.agile.project.model.dto.ProjectUserDTO;
import io.yosep.agile.sprint.domain.dao.SprintDAO;
import io.yosep.agile.sprint.domain.dto.SprintDTO;
import io.yosep.agile.util.ProjectUploadFileUtil;

@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectDAO projectDAO;
	@Autowired
	private SprintDAO sprintDAO;

	@Override
	public List<ProjectDTO> projectList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	// 해당 코드에서 트러블 슈팅!!
	// 원래 프로젝트아이디 = 생성자 + 프로젝트이름
	// 수정 => 프로젝트아이디 = 생성자 + 프로젝트이름 + _uuid
	// but, 이렇게 되면 한 아이디에서 중복된 프로젝트 생성이 가능하게 됨
	// 최종수정 => 프로젝트이름 + _ + 생성자이름, frontEnd에서 정규식을 통해 특수문자 _ 사용하지 못하도록함
	@Transactional
	@Override
	public void createProject(ProjectDTO projectDTO, MultipartHttpServletRequest mtfRequest, HttpSession session)
			throws Exception {
		// TODO Auto-generated method stub
		String userId = (String) session.getAttribute("userId");
		ProjectUserDTO projectUserDTO = new ProjectUserDTO();
		boolean hasUploadFiles = false;

		System.out.println(mtfRequest.getFiles("projectFiles").size());
		projectDTO.setProjectFiles(mtfRequest.getFiles("projectFiles"));
		projectDTO.setSupervisor(userId);
		projectDTO.setProjectId(projectDTO.getProjectName() + "_" + projectDTO.getSupervisor());
		ProjectFileDTO[] projectFileDTO = new ProjectFileDTO[projectDTO.getProjectFiles().size()];
		System.out.println(projectFileDTO.length);

		hasUploadFiles = ProjectUploadFileUtil.makeFirstProjectFile(projectDTO, projectFileDTO);
		projectDAO.createProject(projectDTO);

		if (hasUploadFiles) {
			projectDAO.createProjectFile(projectFileDTO);
		}
		
		projectUserDTO.setUserId(userId);
		projectUserDTO.setProjectId(projectDTO.getProjectId());
		
		projectDAO.insertUserToProject(projectUserDTO);
		
		SprintDTO sprintDTO = new SprintDTO();
		sprintDTO.setSprintId(projectDTO.getProjectId() + "_Sprint#");
		sprintDTO.setProjectId(projectDTO.getProjectId());
		sprintDTO.setSprintName("0");
		sprintDTO.setStartDate(projectDTO.getRegDate());
		sprintDAO.createSprint(sprintDTO);
	}

	@Override
	public ProjectDTO viewProject(ProjectDTO projectDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProject(String projectId) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateProject(ProjectDTO projectDTO) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ProjectDTO> myOwnProjectList(String userId) {
		// TODO Auto-generated method stub
		return projectDAO.myOwnProjectList(userId);
	}

	@Override
	public List<String> usersInTheProject(String projectId) {
		// TODO Auto-generated method stub
		return projectDAO.usersInTheProject(projectId);
	}

}
