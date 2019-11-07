package io.yosep.agile.dashboard.model.dto;

import java.util.List;

import io.yosep.agile.project.model.dto.ProjectDTO;
import io.yosep.agile.sprint.domain.dto.SprintDTO;
import io.yosep.agile.user.model.dto.UserDTO;
import lombok.Data;

@Data
public class DashBoardDTO {
	List<ProjectDTO> projectList;
	List<SprintDTO> sprintList;
	int startSprintCount;
	SprintDTO startSprint;
	UserDTO userDTO;	
}
