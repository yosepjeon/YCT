package io.yosep.agile.task.domain.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class TaskFileDTO {
	long fileId;
	String fileName;
	String taskId;
	Timestamp regDate;
	String fileUrl;
}
