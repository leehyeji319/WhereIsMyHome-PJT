package com.ssafy.myhome.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HouseInfo extends DongCode {
	
	private int houseinfoId;
	private String aptName;
	private int buildYear;
	private String jibun;
	private String lat;
	private String lng;
	private String img;
	
}
