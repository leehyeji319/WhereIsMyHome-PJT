package com.ssafy.myhome.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InterestArea {

	private int interestAreaId;
	private String userId;
	private BaseAddress baseAddress;
	
	private boolean isMain;
	
}
