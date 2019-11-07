package io.yosep.agile.project.model.dto;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class ProjectFileDTO {
	long fileId;
	String fileName;
	String projectId;
	Timestamp regDate;
	String fileUrl;
}
