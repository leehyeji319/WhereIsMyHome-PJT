package com.ssafy.myhome.model.service;

import java.sql.SQLException;
import java.util.Map;

import com.ssafy.myhome.model.dto.UserInfo;

public interface JwtService {

	<T> String createAccessToken(String key, T data);
	<T> String createRefreshToken(String key, T data);
	<T> String create(String key, T data, String subject, long expir);
	Map<String, Object> get(String key);
	String getUserId();
	boolean checkToken(String jwt);
	
}
