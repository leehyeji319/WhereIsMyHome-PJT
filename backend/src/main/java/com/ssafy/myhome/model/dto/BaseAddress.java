package com.ssafy.myhome.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BaseAddress {
	
	private String sidoName;
	private String gugunName;
	private String dongName;
//	private String jibun;
	
	private String lat;
	private String lng;
	
	public String getFullAddress(String jibun) {
		StringBuilder sb = new StringBuilder();
		
		return sb.append(sidoName).append(" ")
				.append(gugunName).append(" ")
				.append(dongName).append(" ")
				.append(jibun).toString();
	}
	
}
