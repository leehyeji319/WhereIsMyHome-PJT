package com.ssafy.myhome.model.dao;

import java.util.List;

import com.ssafy.myhome.model.dto.SaleBoard;

public interface SaleBoardDao {

	SaleBoard getSaleBoard(int boardId);

	List<SaleBoard> getSaleBoards();

	int registerSaleBoard(SaleBoard saleBoard);

	int updateSaleBoard(SaleBoard saleBoard);

	int deleteSaleBoard(int boardId);

}