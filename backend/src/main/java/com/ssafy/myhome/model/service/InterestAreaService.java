package com.ssafy.myhome.model.service;

import java.util.List;

import com.ssafy.myhome.model.dto.DongCommercialArea;
import com.ssafy.myhome.model.dto.InterestArea;

public interface InterestAreaService {

	public boolean insertUserInterestAreaMapping(String userId, String dongCode) throws Exception;
	
	public List<InterestArea> selectInterestAreas(String userId) throws Exception;
	
	public boolean updateUserInteresetAreaMapping(String userId, String dongCode) throws Exception;
	
	public boolean deleteUserInterestAreaMapping(String userId, String dongCode) throws Exception;

	public DongCommercialArea getCommercialLabel(String dongCode) throws Exception;
	
}
