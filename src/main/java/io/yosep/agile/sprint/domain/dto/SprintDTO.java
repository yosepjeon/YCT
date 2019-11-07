package io.yosep.agile.sprint.domain.dto;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class SprintDTO {
	String sprintId;
	String projectId;
	String sprintName;
	String description;
	String state;
	
	Timestamp startDate;
	Timestamp endDate;
}
