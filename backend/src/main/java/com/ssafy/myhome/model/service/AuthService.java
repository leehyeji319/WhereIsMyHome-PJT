package com.ssafy.myhome.model.service;

import com.ssafy.myhome.model.dto.UserInfo;

public interface AuthService {

	boolean signUp(UserInfo userInfo);
	
	UserInfo logIn(UserInfo userInfo);
	UserInfo userInfo(String userId);

	//=== 유효성 검증 ===//
	void validateDuplicateId(String userId);
	void validateDuplicatedNickname(String userNickname);

}
