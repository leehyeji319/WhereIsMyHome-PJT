package com.ssafy.myhome.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileInfo {

	private int fileId;
	private String saveFolder;
	private String originalFile;
	private String saveFile;

}
