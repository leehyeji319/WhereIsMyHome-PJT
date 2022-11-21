package com.ssafy.myhome.model.service;

import java.util.List;

import com.ssafy.myhome.model.dto.SaleBoard;

public interface SaleBoardService {

	SaleBoard getSaleBoard(int boardId);

	List<SaleBoard> getSaleBoards();

	boolean registerSaleBoard(SaleBoard saleBoard);

	boolean updateSaleBoard(SaleBoard saleBoard);

	boolean deleteSaleBoard(int boardId);

}
