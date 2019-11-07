package io.yosep.agile.dashboard.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.yosep.agile.dashboard.model.dto.DashBoardDTO;
import io.yosep.agile.project.model.dao.ProjectDAO;
import io.yosep.agile.sprint.domain.dao.SprintDAO;
import io.yosep.agile.user.model.dao.UserDAO;

@Service
public class DashBoardServiceImpl implements DashBoardService{
	@Autowired
	ProjectDAO projectDAO;
	@Autowired
	UserDAO userDAO;
	@Autowired
	SprintDAO sprintDAO;
	
	@Override
	@Transactional
	public void getDashBoardElements(String projectId, DashBoardDTO dashBoardDTO,HttpSession session) {
		// TODO Auto-generated method stub
		dashBoardDTO.setUserDTO(userDAO.getUserDTOForDashBoard((String)session.getAttribute("userId")));
		dashBoardDTO.setProjectList(projectDAO.myOwnProjectList((String)session.getAttribute("userId")));
		dashBoardDTO.setStartSprint(sprintDAO.getStartSprint(projectId));
		System.out.println("startSprintCount: " + sprintDAO.getSprintCount(projectId));
		dashBoardDTO.setStartSprintCount(sprintDAO.getSprintCount(projectId));
	}
	
}
