package com.ssafy.myhome.model.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Notice extends BasePostForm {

	private int noticeId;
	
	private List<FileInfo> fileInfos;
	
}
