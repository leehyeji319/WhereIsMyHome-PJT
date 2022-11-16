package com.ssafy.myhome.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.myhome.model.dao.UserDao;
import com.ssafy.myhome.model.dto.User;

@Service
public class UserServiceImpl implements UserService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserDao userDAO;

	@Override
	public boolean registerUser(User user) {
		return userDAO.registerUser(user) > 0;
	}

	@Override
	public List<User> getUsers() {
		return userDAO.getUsers();
	}

	@Override
	public User login(String userId, String userPwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(String userId) {
		return userDAO.getUser(userId);
	}

	@Override
	public boolean updateUser(User user) {
		return userDAO.updateUser(user) > 0;
	}

	@Override
	public boolean deleteUser(String userId) {
		return userDAO.deleteUser(userId) > 0;
	}



}













