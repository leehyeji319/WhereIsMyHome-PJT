package com.ssafy.myhome.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.myhome.model.dao.InterestHouseDao;
import com.ssafy.myhome.model.dto.HouseInfo;

@Service
public class InterestHouseServiceImpl implements InterestHouseService {

	@Autowired
	private InterestHouseDao interestHouseDao;
	
	@Override
	public InterestHouseDao getUserInterestHouse(int interestHouseId) {
		return interestHouseDao.getInterestHouse(interestHouseId);
	}

	@Override
	public List<InterestHouseDao> getUserInterestHouses(String userId) {
		return interestHouseDao.getInterestHouses(userId);
	}

	@Override
	public boolean insertUserInterestHouseMapping(String userId, HouseInfo houseInfo) {
		return interestHouseDao.insertUserInterestHouseMapping(userId, houseInfo) > 0;
	}

	@Override
	public boolean deleteUserInterestHouseMapping(int interestHouseId) {
		return interestHouseDao.deleteUserInterestHouseMapping(interestHouseId) > 0;
	}
	
}
