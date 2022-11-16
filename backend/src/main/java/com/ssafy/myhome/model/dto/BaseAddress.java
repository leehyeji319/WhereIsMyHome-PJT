package com.ssafy.myhome.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseAddress extends DongCode {
	
	private int baseaddressId;
	private String lat;
	private String lng;

}
