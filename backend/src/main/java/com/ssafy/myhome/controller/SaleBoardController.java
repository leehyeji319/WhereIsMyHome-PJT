package com.ssafy.myhome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.myhome.model.dto.SaleBoard;
import com.ssafy.myhome.model.service.SaleBoardService;

@RequestMapping("/api/boards")
@RestController
public class SaleBoardController {

	@Autowired
	private SaleBoardService saleBoardService;

	//조회
	@GetMapping("/{boardId}")
	private ResponseEntity<?> getSaleBoard(@PathVariable int boardId) {

		SaleBoard saleBoard = saleBoardService.getSaleBoard(boardId);
		
		if (saleBoard != null) {
			return ResponseEntity.ok(saleBoard);
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	
	//리스트 조회
	@GetMapping
	private ResponseEntity<?> getSaleBoards() {

		List<SaleBoard> saleBoards = saleBoardService.getSaleBoards();
		
		if (saleBoards != null) {
			return ResponseEntity.ok(saleBoards);
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	
	//등록
	@PostMapping()
	private ResponseEntity<?> registerInterestArea(@RequestBody SaleBoard saleBoard) {
		
		boolean res = saleBoardService.registerSaleBoard(saleBoard);
		
		if (res) {
			return ResponseEntity.ok().build(); 
		} else {
			return ResponseEntity.internalServerError().build();
		}

	}

	
	//수정
	@PutMapping("/{boardId}")
	private ResponseEntity<?> updateSaleBoard(@RequestBody SaleBoard saleBoard) {
		
		boolean res = saleBoardService.updateSaleBoard(saleBoard);
		
		if (res) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}
	
	
	//삭제
	@DeleteMapping("/{boardId}")
	public ResponseEntity<?> deleteSaleBoard(@PathVariable int boardId) {
		
		boolean res = saleBoardService.deleteSaleBoard(boardId);
		
		if (res) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
}
