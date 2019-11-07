package io.yosep.agile.sprint.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.yosep.agile.sprint.domain.dao.SprintDAO;
import io.yosep.agile.sprint.domain.dto.SprintDTO;

@Service
public class SprintServiceImpl implements SprintService{
	@Autowired
	SprintDAO sprintDAO;
	
	@Override
	public List<SprintDTO> sprintList(String projectId) throws Exception {
		// TODO Auto-generated method stub
		return sprintDAO.sprintList(projectId);
	}

	@Override
	public int sprintCount(String projectId) throws Exception {
		// TODO Auto-generated method stub
		return sprintDAO.getSprintCount(projectId);
	}

	@Override
	public void createSprint(SprintDTO sprintDTO,HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		sprintDAO.createSprint(sprintDTO);
	}

	@Override
	public int deleteSprint(String sprintId,HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		return sprintDAO.deleteSprint(sprintId);
	}

	@Override
	public boolean startSprint(String sprintId,String projectId) throws Exception {
		// TODO Auto-generated method stub
		return sprintDAO.startSprint(sprintId, projectId);	
	}

	@Override
	public SprintDTO viewSprint(String sprintId) throws Exception {
		// TODO Auto-generated method stub
		return sprintDAO.viewSprint(sprintId);
	}

	@Override
	public SprintDTO getStartSprint(String projectId) {
		// TODO Auto-generated method stub
		return sprintDAO.getStartSprint(projectId);
	}

}
