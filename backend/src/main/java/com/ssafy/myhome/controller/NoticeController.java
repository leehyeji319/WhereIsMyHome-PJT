package com.ssafy.myhome.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.myhome.model.dto.Notice;
import com.ssafy.myhome.model.service.NoticeService;

@RequestMapping("/api/notices")
@RestController
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;

	@PostMapping
	protected ResponseEntity<?> registerNotice(@RequestBody Notice notice) throws Exception {

		boolean res = noticeService.registerNotice(notice);
		
		if (res) {
			return ResponseEntity.created(URI.create("/api/notices")).build(); 
		} else {
			return ResponseEntity.internalServerError().build();
		}
		
	}
	
	@PutMapping("/{noticeId}")
	protected ResponseEntity<?> updateNotice(@RequestBody Notice notice) throws Exception {

		boolean res = noticeService.updateNotice(notice);
		
		if (res) {
			return ResponseEntity.ok(notice);
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@DeleteMapping("/{noticeId}")
	protected ResponseEntity<?> deleteNotice(@PathVariable int noticeId) throws Exception {
	
		boolean res = noticeService.deleteNotice(noticeId);
		
		if (res) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@GetMapping
	protected ResponseEntity<List<Notice>> getNotices() throws Exception {
		
		return ResponseEntity.ok().body(noticeService.getNotices()); 
	
	}
	
	@GetMapping("/{noticeId}")
	protected ResponseEntity<Notice> getNotice(@PathVariable int noticeId) throws Exception {

		Notice notice = noticeService.getNotice(noticeId);
		
		if (notice != null) {
			return ResponseEntity.ok(notice);
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}

}
