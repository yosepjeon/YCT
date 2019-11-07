package io.yosep.agile.user.model.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import io.yosep.agile.user.model.dto.UserDTO;

/*
 * 2019년 6월 4일
 * 작성자: 전요셉
 * 내용: User관련 DB로직을 처리하는 DAO 인터페이스 정의
 */
public interface UserDAO {
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

	// 06. 비밀번호 일치여부 체크
	public boolean checkPassword(String userId, String userPassword);

	// 07. 로그아웃
	public void logout(HttpSession session);

	// 08. 회원 로그인 체크
	public boolean loginCheck(UserDTO userDTO);

	// 09. 회원가입시 같은 아이디 있는지 체크
	public UserDTO sameIdCheck(UserDTO userDTO);
	
	// 10. 대시보드용 회원정보 가져오기
	public UserDTO getUserDTOForDashBoard(String userId);
}
