package com.ssafy.myhome.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.myhome.model.dto.Notice;

@Mapper
public interface NoticeDao {
	
	int registerNotice(Notice notice) throws SQLException;

	int updateNotice(Notice notice) throws SQLException;

	int deleteNotice(int noticeId) throws SQLException;

	List<Notice> getNotices() throws SQLException;
	
	Notice getNotice(int noticeId) throws SQLException;
	
}
