package com.ssafy.myhome.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ssafy.myhome.model.dto.DongCommercialArea;
import com.ssafy.myhome.model.dto.InterestArea;

public interface InterestAreaDao {

	int insertUserInterestAreaMapping(String userId, String dongCode) throws SQLException;
	
	ArrayList<InterestArea> selectInterestAreas(String userId) throws SQLException;
	
	int updateUserInteresetAreaMapping(String userId, String dongCode) throws SQLException;
	
	int deleteUserInterestAreaMapping(String userId, String dongCode) throws SQLException;

	DongCommercialArea getCommercialLabel(String dongCode) throws SQLException;
	
}
