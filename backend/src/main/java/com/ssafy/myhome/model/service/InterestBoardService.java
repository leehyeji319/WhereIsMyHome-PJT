package com.ssafy.myhome.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.myhome.model.dto.InterestBoard;

public interface InterestBoardService {
	
	InterestBoard getUserInterestBoard(int interestBoardId);
	List<InterestBoard> getUserInterestBoards(String userId);
	boolean registerUserInterestBoardMapping(Map<String, Object> map);
	boolean deleteUserInterestBoardMapping(int interestBoardId);
	
}
