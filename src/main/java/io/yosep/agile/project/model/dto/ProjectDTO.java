package io.yosep.agile.project.model.dto;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ProjectDTO {
	String projectId;
	String projectName;
	Timestamp regDate;
	String supervisor;
	String description;
	List<MultipartFile> projectFiles;
}
