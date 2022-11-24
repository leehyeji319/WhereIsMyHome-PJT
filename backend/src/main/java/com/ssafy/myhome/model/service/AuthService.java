package com.ssafy.myhome.model.service;

import com.ssafy.myhome.model.dto.UserInfo;

public interface AuthService {

	boolean signUp(UserInfo userInfo);
	
	UserInfo logIn(UserInfo userInfo);
//	UserInfo userInfo(String userId);
	
	//==효인쌤==//
	public UserInfo login(UserInfo userInfo) throws Exception;
	public UserInfo userInfo(String userId) throws Exception;
	public void saveRefreshToken(String userId, String refreshToken) throws Exception;
	public Object getRefreshToken(String userId) throws Exception;
	public void deleteRefreshToken(String userId) throws Exception;

	//=== 유효성 검증 ===//
	void validateDuplicateId(String userId);
	void validateDuplicatedNickname(String userNickname);

}
