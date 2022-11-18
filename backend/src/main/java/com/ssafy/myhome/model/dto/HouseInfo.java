package com.ssafy.myhome.model.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HouseInfo extends DongCode {
	
	private int houseInfoId;
	private String aptName;
	private int buildYear;
	private String jibun;
	private String lat;
	private String lng;
	private String img;
	
	private List<HouseDeal> houseDeals;
}
