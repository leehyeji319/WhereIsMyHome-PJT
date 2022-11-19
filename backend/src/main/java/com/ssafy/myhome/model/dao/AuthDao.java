package com.ssafy.myhome.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.myhome.model.dto.CompanyInfo;
import com.ssafy.myhome.model.dto.UserInfo;

@Mapper
public interface AuthDao {
	
	int signUpUser(UserInfo userInfo); //o
	int signUpCompany(CompanyInfo companyInfo); //o
	
	UserInfo logIn(UserInfo userInfo); //0
	UserInfo userInfo(String userId);
	
	UserInfo getUser(String userId); 
	
	List<UserInfo> getUsers();
	
	//=== 유저 수정 ===//
	int updateUser(UserInfo userInfo); //0
	int updateCompany(CompanyInfo companyInfo); //0
	
	//=== 유저 삭제 ===//
	int deleteUser(String userId); //0
	
	//=== 유효성 검증 ===//
	int validateDuplicateId(String userId); //0

	//==== jwt ====//
	void saveRefreshToken(Map<String, String> map);
	Object getRefreshToken(String userId);
	void deleteRefreshToken(Map<String, String> map);
}
