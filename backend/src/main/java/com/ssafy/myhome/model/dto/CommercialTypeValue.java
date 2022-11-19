package com.ssafy.myhome.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommercialTypeValue<T> {
	
	private T convenienceStore;
	private T education;
	private T cafe;
	private T restaurant;
	private T health;
	private T market;

}
