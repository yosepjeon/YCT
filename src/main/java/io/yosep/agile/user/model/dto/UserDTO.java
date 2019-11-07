package io.yosep.agile.user.model.dto;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UserDTO {
	private String userId;
	private String userName;
	private String userPassword;
	private String gender;
	private Timestamp regDate;
	private String phoneNum;
	private String userEmail;
	private String userAddr;
	private String deptName;
	private String position;
	private MultipartFile profileImg;
	private String profileUrl;
}
