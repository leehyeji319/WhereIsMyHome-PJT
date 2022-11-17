package com.ssafy.myhome.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommercialArea extends DongCode {
	
	private int convenienceStore;
	private int education;
	private int cafe;
	private int restaurant;
	private int health;
	private int market;
	
	CommercialTypeValue avgDiff;
	CommercialTypeValue totalAvg;
	
	private CommercialLabel label;
	
}
