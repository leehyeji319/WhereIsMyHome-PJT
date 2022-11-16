package com.ssafy.myhome.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class Notice {
	
	private int noticeId;
	private String title;
	private String content;
	private String dateTime;
	private int hit;
	
}
