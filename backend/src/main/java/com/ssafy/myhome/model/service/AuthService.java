package com.ssafy.myhome.model.service;

import java.util.List;

import com.ssafy.myhome.model.dto.CompanyInfo;
import com.ssafy.myhome.model.dto.UserInfo;

public interface AuthService {

	boolean signUp(UserInfo userInfo);
	
	UserInfo logIn(UserInfo userInfo);
	UserInfo userInfo(String userId);
	
	UserInfo getUser(String userId);
	List<UserInfo> getUsers();
	
	boolean updateUser(UserInfo userInfo);
	boolean updateCompany(CompanyInfo companyInfo);
	
	boolean deleteUser(String userId);
	//=== 유효성 검증 ===//
	void validateDuplicateId(String userId);

}
