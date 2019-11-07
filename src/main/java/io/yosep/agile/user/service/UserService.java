package io.yosep.agile.user.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import io.yosep.agile.user.model.dto.UserDTO;

public interface UserService {
	// 01. 회원 목록
	public List<UserDTO> userList();
	
	// 02. 회원정보 입력
	public void insertUser(UserDTO userDTO);
	
	// 03. 회원정보 상세보기
	public UserDTO viewUser(UserDTO userDTO);
	
	// 04. 회원 탈퇴
	public void deleteUser(String userId);
	
	// 05. 회원정보 수정
	public void updateUser(UserDTO userDTO);
	
	// 06. 회원정보 수정 및 삭제를 위한 비밀번호 체크
	public boolean checkPw(String userId, String userPassword);
	
	// 07. 회원 로그인 체크
	public boolean loginCheck(UserDTO userDTO,HttpSession session);
	
	// 08. 회원 로그아웃
	public void logout(HttpSession session);
	
	// 09. 유저아이디 중복체크
	public boolean checkDupUserId(String userId);
	
	// 10. 대시보드용 회원정보 가져오기
	public UserDTO getUserDTOForDashBoard(String userId);
}
