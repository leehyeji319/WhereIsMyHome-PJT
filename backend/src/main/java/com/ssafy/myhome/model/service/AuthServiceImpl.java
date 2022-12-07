package com.ssafy.myhome.model.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.myhome.exception.IllegalUserException;
import com.ssafy.myhome.model.dao.AuthDao;
import com.ssafy.myhome.model.dto.UserInfo;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private AuthDao authDao;
	
	@Override
	public boolean signUp(UserInfo userInfo) {
		
		validateDuplicateId(userInfo.getUserId());
		validateDuplicatedNickname(userInfo.getUserNickname());
		
		if (userInfo.getCompanyInfo() == null) {
			return authDao.signUpUser(userInfo) > 0;
		} else {
			authDao.signUpUser(userInfo);
			String userId = userInfo.getUserId();
			userInfo.getCompanyInfo().setUserId(userId);
			return authDao.signUpCompany(userInfo.getCompanyInfo()) > 0;
		}	
	}

	@Override
	public UserInfo logIn(UserInfo userInfo) {	
		if (userInfo.getUserId() == null || userInfo.getUserPassword() == null) {
			return null;
		}
		return authDao.logIn(userInfo);
	}
	
	//==효인쌤==//
//	@Autowired
//	private SqlSession sqlSession;

	@Override
	public UserInfo login(UserInfo userInfo) throws Exception {
		if (userInfo.getUserId() == null || userInfo.getUserPassword() == null) {
			return null; 
			}
//		return sqlSession.getMapper(AuthDao.class).login(userInfo);
		return authDao.login(userInfo);
	}

	@Override
	public UserInfo userInfo(String userId) throws Exception {
//		return sqlSession.getMapper(AuthDao.class).userInfo(userId);
		return authDao.userInfo(userId);
	}

	@Override
	public void saveRefreshToken(String userId, String refreshToken) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("token", refreshToken);
//		sqlSession.getMapper(AuthDao.class).saveRefreshToken(map);
		authDao.saveRefreshToken(map);
	}

	@Override
	public Object getRefreshToken(String userId) throws Exception {
//		return sqlSession.getMapper(AuthDao.class).getRefreshToken(userId);
		return authDao.getRefreshToken(userId);
	}

	@Override
	public void deleteRefreshToken(String userId) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("token", null);
//		sqlSession.getMapper(AuthDao.class).deleteRefreshToken(map);
		authDao.deleteRefreshToken(map);
	}
	
	//===check validate ===//
	@Override
	public void validateDuplicateId(String userId) {
		if (authDao.validateDuplicateId(userId) == 1) {
			throw new IllegalUserException("이미 존재하는 아이디입니다.");
		}
	}

	@Override
	public void validateDuplicatedNickname(String userNickname) {
		if (authDao.validateDuplicateNickname(userNickname) == 1) {
			throw new IllegalUserException("이미 존재하는 닉네임입니다.");
		}
	}
	
	
	
}
