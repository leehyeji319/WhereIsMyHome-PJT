package com.ssafy.myhome.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.myhome.model.dao.SaleBoardDao;
import com.ssafy.myhome.model.dto.SaleBoard;

@Service
public class SaleBoardServiceImpl implements SaleBoardService {
	
	@Autowired
	private SaleBoardDao saleBoardDao;

	@Override
	public SaleBoard getSaleBoard(int boardId) {
		return saleBoardDao.getSaleBoard(boardId);
	}

	@Override
	public List<SaleBoard> getSaleBoards() {
		return saleBoardDao.getSaleBoards();
	}

	@Override
	public boolean registerSaleBoard(SaleBoard saleBoard) {
		return saleBoardDao.registerSaleBoard(saleBoard) > 0;
	}

	@Override
	public boolean updateSaleBoard(SaleBoard saleBoard) {
		return saleBoardDao.updateSaleBoard(saleBoard) > 0;
	}

	@Override
	public boolean deleteSaleBoard(int boardId) {
		return saleBoardDao.deleteSaleBoard(boardId) > 0;
	}

}
