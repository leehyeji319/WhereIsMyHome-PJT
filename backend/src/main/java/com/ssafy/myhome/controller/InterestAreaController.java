package com.ssafy.myhome.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.myhome.model.service.InterestAreaService;

@RequestMapping("/users/{userId}/areas")
@RestController
public class InterestAreaController {

	@Autowired
	private InterestAreaService interestAreaService;

	private Object getinterestAreas(InterestArea interestArea) throws Exception {
		
		String userId = request.getSession().getAttribute("userid").toString();
		List<InterestArea> interestAreaList = interestAreaService.selectInterestAreas(userId);
		
		return new DataInfoDto("application/json", interestAreaList);
		
	}
	
	@PostMapping
	private ResponseEntity<?> registerInterestArea() throws Exception {
		
		String userId = request.getSession().getAttribute("userid").toString();
		String dongCode = request.getParameter("dongcode");
		
		boolean success = interestAreaService.insertUserInterestAreaMapping(userId, dongCode);
		request.setAttribute("success", success);
		
		return new DataInfoDto("application/json", success);
		
	}

	private Object updateMainInterestAreas(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String userId = request.getSession().getAttribute("userid").toString();
		String dongCode = request.getParameter("dongcode");
		
		boolean success = interestAreaService.updateUserInteresetAreaMapping(userId, dongCode);
		request.setAttribute("success", success);
		
		return new DataInfoDto("application/json", success);
		
	}
	
	private Object deleteInterestArea(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String userId = request.getSession().getAttribute("userid").toString();
		String dongCode = request.getParameter("dongcode");
		
		boolean success = interestAreaService.deleteUserInterestAreaMapping(userId, dongCode);
		request.setAttribute("success", success);
		
		return new DataInfoDto("application/json", success);
		
	}
	
	private Object getCommercialLabel(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String dongCode = request.getParameter("dongcode");
		
		DongCommercialArea dongCommercialLabel = interestAreaService.getCommercialLabel(dongCode);
		
		return new DataInfoDto("application/json", dongCommercialLabel);
		
	}

}
