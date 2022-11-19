package com.ssafy.myhome.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.myhome.model.dao.InterestAreaDao;
import com.ssafy.myhome.model.dto.InterestArea;

@Service
public class InterestAreaServiceImpl implements InterestAreaService {
	
	@Autowired
	private InterestAreaDao interestAreaDao;

	@Override
	public List<InterestArea> getInterestAreas(String userId) {
		return interestAreaDao.getInterestAreas(userId);
	}
	
	@Override
	public boolean registerInterestArea(Map<String, String> params) {
		return interestAreaDao.registerInterestArea(params) > 0;
	}

	@Override
	@Transactional
	public boolean updateMainInterestArea(int areaId) {
		int res1 = interestAreaDao.updateMain1To0InterestArea();
		int res2 = interestAreaDao.updateMain0To1InterestArea(areaId);
		
		return res1 + res2 > 0;
	}

	@Override
	public boolean deleteInterestArea(int areaId) {
		return interestAreaDao.deleteInterestArea(areaId) > 0;
	}

}
