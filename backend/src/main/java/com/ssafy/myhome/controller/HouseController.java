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

import com.ssafy.myhome.model.dto.HouseDeal;
import com.ssafy.myhome.model.dto.HouseInfo;
import com.ssafy.myhome.model.service.HouseService;

@RequestMapping("/api/houses")
@RestController
public class HouseController {

	@Autowired private HouseService houseService;
	
	//집 전체 목록 조회
	@GetMapping
	protected ResponseEntity<List<HouseInfo>> getHouses(
			@RequestParam(required = false) String sidoCode, 
			@RequestParam(required = false) String gugunCode,
			@RequestParam(required = false) String dongCode) {
		
		HashMap<String, Object> conditions = new HashMap<String, Object>();
		if (dongCode != null) conditions.put("dongCode", dongCode);
		if (sidoCode != null) conditions.put("sidoCode", sidoCode);
		if (gugunCode != null) conditions.put("gugunCode", gugunCode);
		String value = getTargetCode(sidoCode, gugunCode, dongCode);
		System.out.println("sido :" + sidoCode + " | gugun :" + gugunCode + " | dong :" + dongCode);
		System.out.println("value 들어간 값: " + value);
		conditions.put("value", value);
		return ResponseEntity.ok(houseService.getHouses(conditions));
		
	}
	
	@GetMapping("/{aptNo}/deals")
	protected ResponseEntity<HouseInfo> getHouseDeals(@PathVariable int aptCode) {
		HouseInfo houseInfo = houseService.getHouseDeals(aptCode);
		if (houseInfo != null) {
			return ResponseEntity.ok(houseInfo);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	//rest api아니고 검색했을 때 target value 구하는 컨트롤러
	protected String getTargetCode(String sidoCode, String gugunCode, String dongCode) {
		if (sidoCode != null && gugunCode == null) {
			return sidoCode.substring(0,2);
		} else if (gugunCode != null && dongCode == null) {
			return gugunCode.substring(0, 5);
		} else {
			return dongCode;
		}
	}
	
}
