package com.ssafy.myhome.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.myhome.model.dto.InterestArea;

public interface InterestAreaService {

	public List<InterestArea> getInterestAreas(String userId);

	public boolean registerInterestArea(Map<String, String> params);
	
	public boolean updateMainInterestArea(int areaId);

	public boolean deleteInterestArea(int areaId);

}
