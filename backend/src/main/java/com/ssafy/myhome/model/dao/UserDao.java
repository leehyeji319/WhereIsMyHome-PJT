package com.ssafy.myhome.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.myhome.model.dto.CompanyInfo;
import com.ssafy.myhome.model.dto.MyPageUserInfo;
import com.ssafy.myhome.model.dto.UserInfo;

@Mapper
public interface UserDao {
	//마이페이지에서 하는 모든것
	UserInfo getUser(String userId);
	List<UserInfo> getUsers();
	int updateUser(UserInfo userInfo);
	int updateCompany(CompanyInfo companyInfo);
	int deleteUser(String userId);
	
	MyPageUserInfo getUserMyPage(String userId);

}
