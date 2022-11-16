package com.ssafy.myhome.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.myhome.model.dto.User;

@Mapper
public interface UserDao {
	
	int registerUser (User user);
	
	List<User> getUsers();
	
	User login(String userId, String userPwd);
	
	User getUser(String userId);
	
	int updateUser(User user);
	
	int deleteUser(String userId);

}
