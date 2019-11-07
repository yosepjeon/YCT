package io.yosep.agile.task.domain.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.yosep.agile.task.domain.dto.TaskDTO;
import io.yosep.agile.task.domain.dto.TaskFileDTO;
import io.yosep.agile.task.domain.dto.TaskUserDTO;

@Repository
public class TaskDAOImpl implements TaskDAO{
	static private final String NAMESPACE = "io.yosep.agile.mapper.taskMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<TaskDTO> taskList(String projectId) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE + ".taskList",projectId);
	}

	@Override
	public int getTaskCount(String projectId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void createTask(TaskDTO taskDTO) {
		// TODO Auto-generated method stub
		sqlSession.insert(NAMESPACE + ".createTask",taskDTO);
	}

	@Override
	public int deleteTask(String taskId) {
		// TODO Auto-generated method stub
		return sqlSession.delete(NAMESPACE + ".deleteTask",taskId);
	}

	@Override
	public int updateTask(TaskDTO taskDTO) {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE + ".updateTask",taskDTO);
	}

	@Override
	public int getTaskCountInSprint(String sprintId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void createTaskFile(TaskFileDTO[] taskFileDTO) {
		// TODO Auto-generated method stub
		if(taskFileDTO.length != 0) {
			for(TaskFileDTO tfd : taskFileDTO) {
				System.out.println(tfd.getTaskId() + "###");
				sqlSession.insert(NAMESPACE + ".insertTaskFile",tfd);
			}
		}else {
			return;
		}
	}

	@Override
	public void insertUserToTask(TaskUserDTO taskUserDTO) {
		// TODO Auto-generated method stub
		sqlSession.insert(NAMESPACE + ".insertUserToTask",taskUserDTO);
	}

	@Override
	public TaskDTO getTask(String taskId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + ".taskDetail",taskId);
	}

	@Override
	public List<TaskDTO> getTaskByStatus(String sprintId,String status) {
		// TODO Auto-generated method stub
		Element element = new Element(sprintId,status);
		return sqlSession.selectList(NAMESPACE + ".getTaskByStatus",element);
	}

	@Override
	public void updateRealTimeTask(TaskDTO taskDTO) {
		// TODO Auto-generated method stub
		sqlSession.update(NAMESPACE + ".updateRealTimeTask", taskDTO);
	}

	class Element {
		String sprintId;
		String status;
		
		public Element(String sprintId, String status) {
			this.sprintId = sprintId;
			this.status = status;
		}
	}

	@Override
	public List<String> getNotProcessTaskFromExpiredSprint(String sprintId) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE + ".getNotProcessTaskFromExpiredSprint",sprintId);
	}

	@Override
	public void changeExpiredSprintToDefaultSprint(String taskId) {
		// TODO Auto-generated method stub
		sqlSession.update(NAMESPACE + ".changeExpiredSprintToDefaultSprint",taskId);
	}
}
