package com.ssafy.myhome.model.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyPageUserInfo extends UserInfo {
	
	private List<Board> myBoards;
	private List<HouseInfo> myInterestBuildings;
	private List<Board> myInterestBoards;

}