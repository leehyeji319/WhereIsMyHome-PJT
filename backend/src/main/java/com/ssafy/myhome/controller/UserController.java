package com.ssafy.myhome.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.myhome.model.dto.User;
import com.ssafy.myhome.model.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RequestMapping("/api/users")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//회원 전체 목록 조회
	@GetMapping
	private ResponseEntity<List<User>> getUsers() {
		return ResponseEntity.ok(userService.getUsers());
	}
	
	//회원 조회
	@GetMapping("/{userId}")
	private ResponseEntity<User> getUser(@PathVariable String userId) {
		System.out.println(userService.getUser(userId));
		return ResponseEntity.ok(userService.getUser(userId));
	}
	
	//회원 등록
	@PostMapping
	private ResponseEntity<?> registerUser(@RequestBody User user) {
		boolean res = userService.registerUser(user);
		
		if (res) { 
			return ResponseEntity.created(URI.create("/api/users/" + user.getUserId())).build();
			
		} else {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	//회원 수정
	@PutMapping("/{userId}")
	private ResponseEntity<?> updateUser(@RequestBody User user) {
		User user2 = userService.getUser(user.getUserId());
		if (user2 != null) {
			boolean res = userService.updateUser(user);
			if (res) {
				return ResponseEntity.ok(user);
			} else {
				return ResponseEntity.internalServerError().build();
			}
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//삭제
	@DeleteMapping("/{userId}")
protected ResponseEntity<?> deleteUser(@PathVariable String userId) {
		
		User user2 = userService.getUser(userId);
		if (user2 != null) {
			boolean res = userService.deleteUser(userId);
			if (res) {
				return ResponseEntity.noContent().build();
			} else {
				return ResponseEntity.internalServerError().build();
			}
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e,Model model) {
		System.out.println("exception 발생 : "+e.getMessage());
		model.addAttribute("errorMsg", e.getMessage());
		return "error";
	}
	
}
