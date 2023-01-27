package com.ssafy.myhome.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.myhome.model.dto.UserInfo;
import com.ssafy.myhome.model.service.AuthService;
import com.ssafy.myhome.model.service.JwtServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RequestMapping("/api/auth")
@RestController
public class AuthController {

	@Autowired
	private AuthService authService;
	
	public static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private JwtServiceImpl jwtService;
	
	//==내꺼==//
	@PostMapping("/signUp")
	public ResponseEntity<?> signup(@RequestBody UserInfo userInfo) {
		boolean res = authService.signUp(userInfo);
		
		if (res) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@PostMapping("/logIn")
	public ResponseEntity<?> login(HttpSession session, @RequestBody UserInfo userInfo) {
		UserInfo loginUser = authService.logIn(userInfo);
		
		if (loginUser != null) {
			session.setAttribute("userId", loginUser.getUserId());
			return ResponseEntity.ok(userInfo.getUserId());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping("/logOut")
	public ResponseEntity<?> logout(HttpSession session) {
		session.invalidate();
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(
			@RequestBody @ApiParam(value = "로그인 시 필요한 회원정보(아이디, 비밀번호).", required = true) UserInfo userInfo) throws Exception {
		
//		System.out.println(userInfo.getUserId());
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		UserInfo loginUser1 = authService.login(userInfo);
//		System.out.println(loginUser1.getUserId());
		
		try {
			UserInfo loginUser = authService.login(userInfo);
			
			if (loginUser != null) {
//				System.out.println("들어옴");
				String accessToken = jwtService.createAccessToken("userId", loginUser.getUserId());// key, data
				String refreshToken = jwtService.createRefreshToken("userId", loginUser.getUserId());// key, data
				authService.saveRefreshToken(userInfo.getUserId(), refreshToken);
				logger.debug("로그인 accessToken 정보 : {}", accessToken);
				logger.debug("로그인 refreshToken 정보 : {}", refreshToken);
				resultMap.put("access-token", accessToken);
				resultMap.put("refresh-token", refreshToken);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} else {
				resultMap.put("message", FAIL);
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			logger.error("로그인 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@ApiOperation(value = "회원인증", notes = "회원 정보를 담은 Token을 반환한다.", response = Map.class)
	@GetMapping("/info/{userId}")
	public ResponseEntity<Map<String, Object>> getInfo(
			@PathVariable("userId") @ApiParam(value = "인증할 회원의 아이디.", required = true) String userId,
			HttpServletRequest request) {
//		logger.debug("userId : {} ", userId);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		if (jwtService.checkToken(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰!!!");
			try {
//				로그인 사용자 정보.
				UserInfo userInfo = authService.userInfo(userId);
				resultMap.put("userInfo", userInfo);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} catch (Exception e) {
				logger.error("정보조회 실패 : {}", e);
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			logger.error("사용 불가능 토큰!!!");
			resultMap.put("message", FAIL);
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@ApiOperation(value = "로그아웃", notes = "회원 정보를 담은 Token을 제거한다.", response = Map.class)
	@GetMapping("/logout/{userId}")
	public ResponseEntity<?> removeToken(@PathVariable("userId") String userId) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		try {
			authService.deleteRefreshToken(userId);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.ACCEPTED;
		} catch (Exception e) {
			logger.error("로그아웃 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);

	}

	@ApiOperation(value = "Access Token 재발급", notes = "만료된 access token을 재발급받는다.", response = Map.class)
	@PostMapping("/refresh")
	public ResponseEntity<?> refreshToken(@RequestBody UserInfo userInfo, HttpServletRequest request)
			throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		String token = request.getHeader("refresh-token");
		logger.debug("token : {}, userInfo : {}", token, userInfo);
		if (jwtService.checkToken(token)) {
			if (token.equals(authService.getRefreshToken(userInfo.getUserId()))) {
				String accessToken = jwtService.createAccessToken("userId", userInfo.getUserId());
				logger.debug("token : {}", accessToken);
				logger.debug("정상적으로 액세스토큰 재발급!!!");
				resultMap.put("access-token", accessToken);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			}
		} else {
			logger.debug("리프레쉬토큰도 사용불!!!!!!!");
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	

}
