package com.ssafy.myhome.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.myhome.model.dto.InterestHouse;

public interface InterestHouseService {

	InterestHouse getUserInterestHouse(int interestHouseId);
	List<InterestHouse> getUserInterestHouses(String userId);
	boolean registerUserInterestHouseMapping(Map<String, Object> map);
	boolean deleteUserInterestHouseMapping(int interestHouseId);
	
}
