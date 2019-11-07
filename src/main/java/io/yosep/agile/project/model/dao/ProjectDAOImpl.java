package io.yosep.agile.project.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.yosep.agile.project.model.dto.ProjectDTO;
import io.yosep.agile.project.model.dto.ProjectFileDTO;
import io.yosep.agile.project.model.dto.ProjectUserDTO;
import io.yosep.agile.user.model.dto.UserDTO;

@Repository
public class ProjectDAOImpl implements ProjectDAO {
	static private final String NAMESPACE = "io.yosep.agile.mapper.projectMapper";

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<ProjectDTO> projectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createProject(ProjectDTO projectDTO) {
		// TODO Auto-generated method stub
		sqlSession.insert(NAMESPACE + ".createProject", projectDTO);
	}

	@Override
	public ProjectDTO viewProject(ProjectDTO projectDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProject(String projectId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateProject(ProjectDTO projectDTO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createProjectFile(ProjectFileDTO[] projectFileDTO) {
		// TODO Auto-generated method stub
		if (projectFileDTO.length != 0) {
			for (ProjectFileDTO pfd : projectFileDTO) {
				sqlSession.insert(NAMESPACE + ".insertProjectFile", pfd);
			}
		} else {
			return;
		}
	}

	@Override
	public List<ProjectDTO> myOwnProjectList(String userId) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE + ".myOwnProjectList", userId);
	}

	@Override
	public void insertUserToProject(ProjectUserDTO projectUserDTO) {
		// TODO Auto-generated method stub
		sqlSession.insert(NAMESPACE + ".insertUserToProject",projectUserDTO);
	}

	@Override
	public List<String> usersInTheProject(String projectId) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE + ".getUsersInTheProject",projectId);
	}

}
