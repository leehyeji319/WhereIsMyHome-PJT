package com.ssafy.myhome.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.myhome.model.dao.HouseInfoDao;
import com.ssafy.myhome.model.dto.HouseInfo;

@Service
public class HouseInfoServiceImpl implements HouseInfoService {

	@Autowired
	private HouseInfoDao houseInfoDao;
	
	@Override
	public List<HouseInfo> getHouses(Map<String, Object> conditions) {
		return houseInfoDao.getHouses(conditions);
	}
	
	@Override
	public HouseInfo getHouse(int aptCode) {
		return houseInfoDao.getHouse(aptCode);
	}

	@Override
	public HouseInfo getHouseDeals(int aptCode) {
		return houseInfoDao.getHouseDeals(aptCode);
	}

	@Override
	public HouseInfo getHousesSearchByDongName(String dongName) {
		return houseInfoDao.getHousesSearchByDongName(dongName);
	}

	@Override
	public HouseInfo getHousesSearchByDongNameWithHouseDeals(String dongName) {
		return houseInfoDao.getHousesSearchByDongNameWithHouseDeals(dongName);
	}
	
}
