package com.ssafy.myhome.model.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class HouseDeal {

	int no;
	int aptCode;
	String dealAmount;
	int dealYear;
	int dealMonth;
	int dealDay;
	String area;
	String floor;
	String type;
	String rentMoney;
	
}
