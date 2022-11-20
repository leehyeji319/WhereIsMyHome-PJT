package com.ssafy.myhome.model.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyPageUserInfo extends UserInfo {
	
	private List<SaleBoard> myBoards;
	private List<InterestHouse> myInterestHouses;
	private List<InterestBoard> myInterestBoards;

}