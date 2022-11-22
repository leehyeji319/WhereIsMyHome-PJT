package com.ssafy.myhome.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.myhome.model.dto.UserInfo;
import com.ssafy.myhome.model.service.AuthService;

@RequestMapping("/api/auth")
@RestController
public class AuthController {

	@Autowired
	private AuthService authService;
	
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody UserInfo userInfo) {
		boolean res = authService.signUp(userInfo);
		
		if (res) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(HttpSession session, @RequestBody UserInfo userInfo) {
		UserInfo loginUser = authService.logIn(userInfo);
		
		if (loginUser != null) {
			session.setAttribute("userId", loginUser.getUserId());
			return ResponseEntity.ok(userInfo.getUserId());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping("/logout")
	public ResponseEntity<?> logout(HttpSession session) {
		session.invalidate();
		return ResponseEntity.ok().build();
	}

}
