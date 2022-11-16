package com.ssafy.myhome.model.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

//@Data
//@ToString
//@AllArgsConstructor
@Getter
@Setter
public class HouseInfo {
	
	int aptCode;
	String aptName;
	String sidoName;
	String gugunName;
	String dongName;
	String dongCode;
	String buildYear;
	String jibun;
	String lat;
	String lng;
	
	List<HouseDeal> houseDeals;
	
	
}
