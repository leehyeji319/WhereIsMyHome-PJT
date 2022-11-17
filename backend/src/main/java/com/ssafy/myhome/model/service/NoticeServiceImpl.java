package com.ssafy.myhome.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.myhome.model.dao.NoticeDao;
import com.ssafy.myhome.model.dto.Notice;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeDao noticeDao;

	@Override
	public boolean registerNotice(Notice notice) throws Exception {
		return noticeDao.registerNotice(notice) > 0;
	}
	
	@Override
	public boolean updateNotice(Notice notice) throws Exception {
		return noticeDao.updateNotice(notice) > 0;
	}

	@Override
	public boolean deleteNotice(int noticeId) throws Exception {
		return noticeDao.deleteNotice(noticeId) > 0;
	}

	@Override
	public List<Notice> getNotices() throws Exception {
		return noticeDao.getNotices();
	}

	@Override
	public Notice getNotice(int noticeId) throws Exception {
		return noticeDao.getNotice(noticeId);
	}

}
