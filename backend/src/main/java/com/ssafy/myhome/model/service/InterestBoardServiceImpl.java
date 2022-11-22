package com.ssafy.myhome.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.myhome.model.dao.InterestBoardDao;
import com.ssafy.myhome.model.dto.InterestBoard;

@Service
public class InterestBoardServiceImpl implements InterestBoardService {

	@Autowired
	private InterestBoardDao interestBoardDao;

	@Override
	public InterestBoard getUserInterestBoard(int interestBoardId) {
		return interestBoardDao.getUserInterestBoard(interestBoardId);
	}

	@Override
	public List<InterestBoard> getUserInterestBoards(String userId) {
		return interestBoardDao.getUserInterestBoards(userId);
	}

	@Override
	public boolean registerUserInterestBoardMapping(Map<String, Object> map) {
		return interestBoardDao.registerUserInterestBoardMapping(map) > 0;
	}

	@Override
	public boolean deleteUserInterestBoardMapping(int interestBoardId) {
		return interestBoardDao.deleteUserInterestBoardMapping(interestBoardId) > 0;
	}

}
