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

import com.ssafy.myhome.model.dto.HouseInfo;
import com.ssafy.myhome.model.dto.InterestHouse;
import com.ssafy.myhome.model.service.InterestHouseService;

@RequestMapping("/api/users/interests/houses")
@RestController
public class InterestHouseController {
	
	@Autowired
	private InterestHouseService interestHouseService;
	
	@GetMapping("/{house_id}")
	private ResponseEntity<InterestHouse> getUserInterestHouse(@PathVariable("house_id") int interestHouseId) {
		
		InterestHouse interestHouse = interestHouseService.getUserInterestHouse(interestHouseId);
		if (interestHouse != null) {
			return ResponseEntity.ok(interestHouse);
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@GetMapping
	private ResponseEntity<List<InterestHouse>> getUserInterestHouses(@RequestParam(required = true) String userId) {
		
		return ResponseEntity.ok(interestHouseService.getUserInterestHouses(userId));
		
	}
	
	@PostMapping
	private ResponseEntity<?> insertUserInterestHouseMapping(@RequestParam(required = true) String userId, 
			@RequestBody HouseInfo houseInfo) {
		
		boolean res = interestHouseService.insertUserInterestHouseMapping(userId, houseInfo);
		
		if (res) {
			return ResponseEntity.created(URI.create("api/houses/" + houseInfo.getHouseInfoId())).build();
		} else {
			return ResponseEntity.internalServerError().build();
		}
		
	}
	
	@DeleteMapping("/{house_id}")
	private ResponseEntity<?> deleteUserInterestHouseMapping(@PathVariable("house_id") int interestHouseId) {
		
		boolean res = interestHouseService.deleteUserInterestHouseMapping(interestHouseId);
		
		if (res) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.internalServerError().build();
		}
	}
}
