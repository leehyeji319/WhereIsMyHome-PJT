package com.ssafy.myhome.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.myhome.model.dto.InterestArea;
import com.ssafy.myhome.model.service.InterestAreaService;

@RequestMapping("/api/users/interests/areas")
@RestController
public class InterestAreaController {

	@Autowired
	private InterestAreaService interestAreaService;

	//리스트 조회
	@GetMapping
	private ResponseEntity<?> getInterestAreas(@RequestParam String userId) {

		List<InterestArea> interestAreas = interestAreaService.getInterestAreas(userId);
		
		if (interestAreas != null) {
			return ResponseEntity.ok(interestAreas);
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	
//	//관심 지역의 상권 라벨 조회
//	@GetMa
//	private ResponseEntity<?> getCommercialLabel(@RequestParam String userId) {
//		
//		String dongCode = request.getParameter("dongcode");
//		
//		CommercialArea commercialLabel = interestAreaService.getCommercialLabel(dongCode);
//		
//		return new DataInfoDto("application/json", dongCommercialLabel);
//		
//	}
	
	
	//등록
	@GetMapping("/{dongCode}")
	private ResponseEntity<?> registerInterestArea(@RequestParam String userId, @PathVariable String dongCode) {
	
		Map<String, String> params = new HashMap<String, String>();
		params.put("userId", userId);
		params.put("dongCode", dongCode);
		
		boolean res = interestAreaService.registerInterestArea(params);
		
		if (res) {
			return ResponseEntity.ok().build(); 
		} else {
			return ResponseEntity.internalServerError().build();
		}

	}

	
	//수정
	@PatchMapping("/{areaId}")
	private ResponseEntity<?> updateMainInterestArea(@PathVariable int areaId) {
		
		boolean res = interestAreaService.updateMainInterestArea(areaId);
		
		if (res) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}
	
	
	//삭제
	@DeleteMapping("/{areaId}")
	public ResponseEntity<?> deleteInterestArea(@PathVariable int areaId) {
		
		boolean res = interestAreaService.deleteInterestArea(areaId);
		
		if (res) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}

}
