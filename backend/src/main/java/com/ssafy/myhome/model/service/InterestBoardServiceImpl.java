package com.ssafy.myhome.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.myhome.model.dao.InterestBoardDao;
import com.ssafy.myhome.model.dto.Board;
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
	public boolean insertUserInterestBoardMapping(String userId, Board board) {
		return interestBoardDao.insertUserInterestBoardMapping(userId, board) > 0;
	}

	@Override
	public boolean deleteUserInterestBoardMapping(int interestBoardId) {
		return interestBoardDao.deleteUserInterestBoardMapping(interestBoardId) > 0;
	}
	
	
}
