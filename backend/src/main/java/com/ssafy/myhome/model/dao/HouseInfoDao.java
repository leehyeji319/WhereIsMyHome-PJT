package com.ssafy.myhome.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.myhome.model.dto.HouseInfo;

@Mapper
public interface HouseInfoDao {
	
	List<HouseInfo> getHouses(Map<String, Object> conditions);
	HouseInfo getHouse(int aptCode);
	HouseInfo getHouseDeals(int aptCode);
	
}
