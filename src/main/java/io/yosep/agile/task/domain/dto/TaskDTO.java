package io.yosep.agile.task.domain.dto;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class TaskDTO {
	String taskId;
	String sprintId;
	String projectId;
	String taskName;
	String taskStatus;
	String taskPriority;
	String description;
	String assignee;
	List<MultipartFile> attachments;
	String fileUrl;
	
	Timestamp startDate;
	Timestamp endDate;
	String reporter;
}
