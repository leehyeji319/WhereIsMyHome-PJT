package com.ssafy.myhome.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.myhome.model.dto.HouseInfo;
import com.ssafy.myhome.model.dto.InterestHouse;

@Mapper
public interface InterestHouseDao {

	InterestHouse getUserInterestHouse(int interestHouseId);
	List<InterestHouse> getUserInterestHouses(String userId);
	int insertUserInterestHouseMapping(String userId, HouseInfo houseInfo);
	int deleteUserInterestHouseMapping(int interestHouseId);
	
}