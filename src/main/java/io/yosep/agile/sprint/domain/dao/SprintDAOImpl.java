package io.yosep.agile.sprint.domain.dao;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.yosep.agile.sprint.domain.dto.SprintDTO;

@Repository
public class SprintDAOImpl implements SprintDAO{
	static private final String NAMESPACE = "io.yosep.agile.mapper.sprintMapper";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<SprintDTO> sprintList(String projectId) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE + ".sprintList",projectId);
	}

	@Override
	public int getSprintCount(String projectId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + ".sprintCount",projectId);
	}

	@Override
	public void createSprint(SprintDTO sprintDTO) {
		// TODO Auto-generated method stub
		sqlSession.insert(NAMESPACE + ".createSprint",sprintDTO);
	}

	@Override
	public int deleteSprint(String sprintId) {
		// TODO Auto-generated method stub
		return sqlSession.delete(NAMESPACE + ".deleteSprint",sprintId);
	}

	@Override
	public SprintDTO viewSprint(String sprintId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + ".viewSprint",sprintId);
	}
	
	@Override
	public boolean startSprint(String sprintId,String projectId) {
		// TODO Auto-generated method stub
		if((int)sqlSession.selectOne(NAMESPACE + ".countStartSprintInTheProject",projectId) == 0) {
			sqlSession.update(NAMESPACE + ".startSprint",sprintId);
			return true;
		}
		
		return false;
	}

	@Override
	public SprintDTO getStartSprint(String projectId) {
		// TODO Auto-generated method stub
		
		return sqlSession.selectOne(NAMESPACE + ".getStartSprint", projectId);
	}

	@Override
	public List<String> getExpiredSprint(String time) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE + ".getExpiredSprint",time);
	}

}
