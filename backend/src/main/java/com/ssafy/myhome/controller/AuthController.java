package com.ssafy.myhome.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/{user_id}")
	public ResponseEntity<UserInfo> getUser(HttpSession session, @PathVariable("user_id") String userId) {
		
		UserInfo user = (UserInfo) session.getAttribute("userId");
		System.out.println(user.getUserId());
		if (user.getUserId() == userId) {
			UserInfo res = authService.getUser(userId);
			
			return ResponseEntity.ok(res);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<UserInfo>> getUsers() {
		
		return ResponseEntity.ok(authService.getUsers());
		
	}
	
	@PutMapping("/{user_id}")
	public ResponseEntity<UserInfo> updateUser(@RequestParam UserInfo userInfo) {
		
		boolean res = authService.updateUser(userInfo);
		
		if (res) {
			return ResponseEntity.ok(userInfo);
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
}
