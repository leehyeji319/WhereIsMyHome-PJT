package com.ssafy.myhome.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.myhome.model.dto.HouseInfo;

public interface HouseInfoService {
	
	//Map안에 sidoCode, gugunCode, dongCode
	List<HouseInfo> getHouses(Map<String,Object> conditions);
	HouseInfo getHouse(int aptCode);
	HouseInfo getHouseDeals(int aptCode);
	HouseInfo getHousesSearchByDongName(String dongName);
	HouseInfo getHousesSearchByDongNameWithHouseDeals(String dongNAme);
}
