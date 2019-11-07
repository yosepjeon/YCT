package io.yosep.agile.user.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.yosep.agile.user.model.dao.UserDAO;
import io.yosep.agile.user.model.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDAO userDAO;

	@Override
	public List<UserDTO> userList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		userDAO.insertUser(userDTO);
	}

	@Override
	public UserDTO viewUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return userDAO.viewUser(userDTO);
	}

	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkPw(String userId, String userPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean loginCheck(UserDTO userDTO,HttpSession session) {
		// TODO Auto-generated method stub
		boolean result = userDAO.loginCheck(userDTO);
		
		if(result) {
			UserDTO user = viewUser(userDTO);
			
			// 세션 변수 등록
			session.setAttribute("userId", user.getUserId());
			session.setAttribute("userName", user.getUserName());
			session.setAttribute("profile", user.getProfileUrl());
		}
		return result;
	}

	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub
		session.invalidate();
	}

	// 작성일: 2019년 06월 10일
	// 작성자: 전요셉
	// 내용: 동일한 회원있는지 여부 체크
	@Override
	public boolean checkDupUserId(String userId) {
		// TODO Auto-generated method stub
		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(userId);
		UserDTO result = userDAO.sameIdCheck(userDTO);
		
		if(result == null) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public UserDTO getUserDTOForDashBoard(String userId) {
		// TODO Auto-generated method stub
		return userDAO.getUserDTOForDashBoard(userId);
	}
	
}
