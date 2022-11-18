package com.ssafy.myhome.model.service;

import java.util.List;

import com.ssafy.myhome.model.dto.HouseInfo;
import com.ssafy.myhome.model.dto.InterestHouse;

public interface InterestHouseService {

	InterestHouse getUserInterestHouse(int interestHouseId);
	List<InterestHouse> getUserInterestHouses(String userId);
	boolean insertUserInterestHouseMapping(String userId, HouseInfo houseInfo);
	boolean deleteUserInterestHouseMapping(int interestHouseId);
	
}
