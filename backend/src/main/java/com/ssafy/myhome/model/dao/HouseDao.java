package com.ssafy.myhome.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.myhome.model.dto.HouseInfo;

@Mapper
public interface HouseDao {

	List<HouseInfo> getHouses(Map<String,Object> conditions);

	HouseInfo getHouseDeals(int aptcode);

}
