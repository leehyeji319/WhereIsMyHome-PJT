package com.ssafy.myhome.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommercialArea {
	
	private String dongCode;
	
	private CommercialTypeValue<Integer> count;
	private CommercialTypeValue<Double> avgDiff; //totalAvg(전국의 상점 개수 평균) - count(이 지역의 상점 개수 카운트)
//	private CommercialTypeValue<Double> totalAvg;

	private CommercialLabel label;
	
}
