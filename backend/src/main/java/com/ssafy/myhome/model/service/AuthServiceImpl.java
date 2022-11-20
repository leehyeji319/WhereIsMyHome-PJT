package com.ssafy.myhome.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.myhome.exception.advice.IllegalUserException;
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
	
	@Override
	public UserInfo userInfo(String userId) {
		return authDao.userInfo(userId);
	}
	
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
