package com.ssafy.myhome.model.service;

import java.util.List;

import com.ssafy.myhome.model.dto.User;

public interface UserService {
	
	boolean registerUser (User user);
	
	List<User> getUsers();
	
	User login(String userId, String userPwd);
	
	User getUser(String userId);
	
	boolean updateUser(User user);
	
	boolean deleteUser(String userId);
}
