package com.ssafy.myhome.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.myhome.model.dto.InterestArea;

@Mapper
public interface InterestAreaDao {
	
	List<InterestArea> getInterestAreas(String userId);
	
	int registerInterestArea(Map<String, String> params);

	int updateMain1To0InterestArea();

	int updateMain0To1InterestArea(int areaId);

	int deleteInterestArea(int areaId);
		
}
