package io.yosep.agile.user.model.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.yosep.agile.user.model.dto.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO {
	static private final String NAMESPACE = "io.yosep.agile.mapper.userMapper";

	@Autowired
	SqlSession sqlSession;

	@Override
	public boolean loginCheck(UserDTO userDTO) {
		// TODO Auto-generated method stub
		String name = sqlSession.selectOne(NAMESPACE + ".loginCheck", userDTO);
		return (name == null) ? false : true;
	}

	@Override
	public List<UserDTO> userList() {
		// TODO Auto-generated method stub
		return null;
	}

	// 작성일: 2019년 6월 4일
	// 작성자: 전요셉
	// 내용: 회원등록 DB 기능구현
	@Override
	public void insertUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		sqlSession.insert(NAMESPACE + ".insertUser", userDTO);
	}

	@Override
	public UserDTO viewUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + ".viewUser",userDTO);
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
	public boolean checkPassword(String userId, String userPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub

	}

	// 작성일: 2019년 06월 10일
	// 작성자: 전요셉
	// 내용: 회원가입시에 이미 해당아이디로 가입된 아이디가 있는지 여부 체크

	@Override
	public UserDTO sameIdCheck(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + ".checkSameId", userDTO);
	}

	@Override
	public UserDTO getUserDTOForDashBoard(String userId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + ".getUserForDashBoard",userId);
	}

}
