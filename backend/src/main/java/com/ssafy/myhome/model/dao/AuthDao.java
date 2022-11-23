package com.ssafy.myhome.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.myhome.model.dto.CompanyInfo;
import com.ssafy.myhome.model.dto.UserInfo;

@Mapper
public interface AuthDao {
	
	int signUpUser(UserInfo userInfo);
	int signUpCompany(CompanyInfo companyInfo);
	
	UserInfo logIn(UserInfo userInfo);
	UserInfo userInfo(String userId);
	
	//=== 유효성 검증 ===//
	int validateDuplicateId(String userId); //0
	int validateDuplicateNickname(String userNickname);
}
