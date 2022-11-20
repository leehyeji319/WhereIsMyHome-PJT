package com.ssafy.myhome.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.myhome.model.dao.UserDao;
import com.ssafy.myhome.model.dto.MyPageUserInfo;
import com.ssafy.myhome.model.dto.UserInfo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public UserInfo getUser(String userId) {
		return userDao.getUser(userId);
	}

	@Override
	public List<UserInfo> getUsers() {
		return userDao.getUsers();
	}

	@Override
	public boolean updateUser(UserInfo userInfo) {
		if (userInfo.getCompanyInfo().getUserId() == null) {
			return userDao.updateUser(userInfo) > 0;
		} else {
			userDao.updateUser(userInfo);
			return userDao.updateCompany(userInfo.getCompanyInfo()) > 0;
		}
	}
	
	@Override
	public boolean deleteUser(String userId) {
		return userDao.deleteUser(userId) > 0;
	}

	@Override
	public MyPageUserInfo getUserMyPage(String userId) {
		return userDao.getUserMyPage(userId);
	}

	
	
}
