package com.ssafy.myhome.model.service;

import java.util.List;

import com.ssafy.myhome.model.dto.Notice;

public interface NoticeService {
	
	boolean registerNotice(Notice notice) throws Exception;

	boolean updateNotice(Notice notice) throws Exception;

	boolean deleteNotice(int noticeId) throws Exception;

	List<Notice> getNotices() throws Exception;

	Notice getNotice(int noticeId) throws Exception;
	
}
