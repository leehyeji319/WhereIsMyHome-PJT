package com.ssafy.myhome.model.service;

import java.util.List;

import com.ssafy.myhome.model.dto.MyPageUserInfo;
import com.ssafy.myhome.model.dto.UserInfo;

public interface UserService {
	
	UserInfo getUser(String userId);
	List<UserInfo> getUsers();
	
	boolean updateUser(UserInfo userInfo);
	boolean deleteUser(String userId);
	
	MyPageUserInfo getUserMyPage(String userId);
}
