package com.ssafy.myhome.model.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comment {
	
	private int commentId;
	private String userId;
	private String userNickname;
	private int commentParent;
	private int boardId;
	private String content;
	private String createdAt;
	private String updatedAt;
	private int isDeleted;
	
	List<Comment> nestedComments; //답글
	
}
