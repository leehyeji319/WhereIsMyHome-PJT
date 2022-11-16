package com.ssafy.myhome.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InterestArea {

	private String userid;
	private String dongCode;
	private int isMain;
	
	private BaseAddress baseAddress;
	
}
