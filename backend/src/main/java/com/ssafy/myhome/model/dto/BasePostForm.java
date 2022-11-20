package com.ssafy.myhome.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BasePostForm {
	
	private String title;
	private String content;
	private int hit;
	private String createdAt;
	private String updatedAt;
	private UserInfo userInfo;
	private int isDeleted;
	
}
