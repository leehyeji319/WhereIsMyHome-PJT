package com.ssafy.myhome.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.myhome.model.dto.HouseInfo;
import com.ssafy.myhome.model.service.HouseInfoService;

@RequestMapping("/houses")
@RestController
public class HouseInfoController {
	
	@Autowired
	private HouseInfoService houseInfoService;
	
	@GetMapping
	private ResponseEntity<List<HouseInfo>> getHouses(
			@RequestParam(required = false) String sidoCode, 
			@RequestParam(required = false) String gugunCode,
			@RequestParam(required = false) String dongCode) {
		
		HashMap<String, Object> conditions = new HashMap<String, Object>();
		if (dongCode != null) conditions.put("dongCode", dongCode);
		if (sidoCode != null) conditions.put("sidoCode", sidoCode);
		if (gugunCode != null) conditions.put("gugunCode", gugunCode);
		String value = getTargetCode(sidoCode, gugunCode, dongCode);
		conditions.put("value", value);
		return ResponseEntity.ok(houseInfoService.getHouses(conditions));
		
	}
	
	@GetMapping("/{house_id}")
	private ResponseEntity<HouseInfo> getHouse(@PathVariable("house_id") int aptCode) {
		HouseInfo houseinfo = houseInfoService.getHouse(aptCode);
		if (houseinfo != null) {
			return ResponseEntity.ok(houseinfo);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/{house_id}/deals")
	private ResponseEntity<HouseInfo> getHouseDeals(@PathVariable("house_id") int aptCode) {
		HouseInfo houseInfo = houseInfoService.getHouseDeals(aptCode);
		if (houseInfo != null) {
			return ResponseEntity.ok(houseInfo);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	private String getTargetCode(String sidoCode, String gugunCode, String dongCode) {
		if (sidoCode != null && gugunCode == null) {
			return sidoCode.substring(0,2);
		} else if (gugunCode != null && dongCode == null) {
			return gugunCode.substring(0, 5);
		} else {
			return dongCode;
		}
	}

}
