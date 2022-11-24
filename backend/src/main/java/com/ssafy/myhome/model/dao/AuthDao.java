package com.ssafy.myhome.model.dao;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.myhome.model.dto.CompanyInfo;
import com.ssafy.myhome.model.dto.UserInfo;

@Mapper
public interface AuthDao {
	
	int signUpUser(UserInfo userInfo);
	int signUpCompany(CompanyInfo companyInfo);
	
	UserInfo logIn(UserInfo userInfo);
//	UserInfo userInfo(String userId);
	
	// 효인 쌤 //
	public UserInfo login(UserInfo userInfo) throws SQLException;
	public UserInfo userInfo(String userId) throws SQLException;
	public void saveRefreshToken(Map<String, String> map) throws SQLException;
	public Object getRefreshToken(String userId) throws SQLException;
	public void deleteRefreshToken(Map<String, String> map) throws SQLException;
	
	
	//=== 유효성 검증 ===//
	int validateDuplicateId(String userId); //0
	int validateDuplicateNickname(String userNickname);
}
