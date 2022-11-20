package com.ssafy.myhome.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.myhome.model.dto.MyPageUserInfo;
import com.ssafy.myhome.model.dto.UserInfo;
import com.ssafy.myhome.model.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RequestMapping("/api/users")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//유저 전체정보 가져오기
	@GetMapping
	private ResponseEntity<List<UserInfo>> getUsers() {
		return ResponseEntity.ok(userService.getUsers());
	}
	
	//유저한명 가져오기
	@GetMapping("/user")
	private ResponseEntity<UserInfo> getUser(@RequestParam(required = true) String userId) {
		UserInfo user = userService.getUser(userId);
		if (user != null) {
			return ResponseEntity.ok(user);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//mypage정보가져오기
	@GetMapping("/user/mypage")
	private ResponseEntity<MyPageUserInfo> getUserMyPage(@RequestParam(required = true) String userId) {
		MyPageUserInfo userMyPage = userService.getUserMyPage(userId);
		if (userMyPage != null) {
			return ResponseEntity.ok(userMyPage);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//유저 수정
	@PutMapping
	private ResponseEntity<?> updateUser(@RequestBody UserInfo userInfo) {
		boolean res = userService.updateUser(userInfo);
		
		if (res) {
			return ResponseEntity.ok(userInfo);
		} else {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	//유저 삭제 is_deleted off
	@DeleteMapping("/user")
	private ResponseEntity<?> deleteUser(@RequestParam(required = true) String userId) {
		
		boolean res = userService.deleteUser(userId);
		
		if (res) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.internalServerError().build();
		}
	}
}
