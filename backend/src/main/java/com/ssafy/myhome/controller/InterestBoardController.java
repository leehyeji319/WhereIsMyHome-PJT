package com.ssafy.myhome.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.myhome.model.dto.SaleBoard;
import com.ssafy.myhome.model.dto.InterestBoard;
import com.ssafy.myhome.model.service.InterestBoardService;

@RequestMapping("/api/user/interests/boards")
@RestController
public class InterestBoardController {

	@Autowired
	private InterestBoardService interestBoardService;
	
	@GetMapping("/{board_id}")
	private ResponseEntity<InterestBoard> getUserInterestBoard(@PathVariable("board_id") int interestBoardId) {
		InterestBoard interestBoard = interestBoardService.getUserInterestBoard(interestBoardId);
		if (interestBoard != null) {
			return ResponseEntity.ok(interestBoard);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping
	private ResponseEntity<List<InterestBoard>> getUserInterestBoards(@RequestParam(required = true) String userId) {
		
		return ResponseEntity.ok(interestBoardService.getUserInterestBoards(userId));
	
	}
	
	@PostMapping
	private ResponseEntity<?> insertUserInterestBoardMapping(@RequestParam(required = true) String userId,
			@RequestBody SaleBoard board) {
		
		boolean res = interestBoardService.insertUserInterestBoardMapping(userId, board);
		
		if (res) {
			return ResponseEntity.created(URI.create("api/users/interest/boards/" + board.getBoardId())).build();
		} else {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@DeleteMapping("/{board_id}")
	private ResponseEntity<?> deleteUserInterestBoardMapping(@PathVariable("board_id") int interestBoardId) {
		boolean res = interestBoardService.deleteUserInterestBoardMapping(interestBoardId);
		
		if (res) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.internalServerError().build();
		}
	}
	
}
