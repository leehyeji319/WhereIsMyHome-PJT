package com.ssafy.myhome.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.myhome.model.dto.HouseInfo;

@Mapper
public interface InterestHouseDao {

	InterestHouseDao getUserInterestHouse(int interestHouseId);
	List<InterestHouseDao> getUserInterestHouses(String userId);
	
	int insertUserInterestHouseMapping(String userId, HouseInfo houseInfo);
	int deleteUserInterestHouseMapping(int interestHouseId);
	
}