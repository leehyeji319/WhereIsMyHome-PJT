package com.ssafy.myhome.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.myhome.model.dto.HouseInfo;

public interface HouseService {
	
	//Map안에 sidoCode, gugunCode, dongCode
	List<HouseInfo> getHouses(Map<String,Object> conditions);
	
	HouseInfo getHouseDeals(int aptCode);
}
