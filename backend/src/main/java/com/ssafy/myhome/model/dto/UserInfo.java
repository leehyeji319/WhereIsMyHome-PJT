package com.ssafy.myhome.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfo {
	
	private String userId;
	private String userPassword;
	private String userName;
	private String userPhone;
	private String userNickname;
	private UserRole userRole;
	private boolean isDeleted;
	
	private CompanyInfo companyInfo;
	private FileInfo userFileInfo;
	
}
