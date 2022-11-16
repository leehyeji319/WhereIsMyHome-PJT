package com.ssafy.myhome.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.myhome.model.dao.HouseDao;
import com.ssafy.myhome.model.dto.HouseInfo;

@Service
public class HouseServiceImpl implements HouseService {

	@Autowired
	private HouseDao houseDAO;


	@Override
	public List<HouseInfo> getHouses(Map<String,Object> conditions) {
		return houseDAO.getHouses(conditions);
	}

	@Override
	public HouseInfo getHouseDeals(int aptCode) {
		return houseDAO.getHouseDeals(aptCode);
	}


}
