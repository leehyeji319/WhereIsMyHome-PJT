package com.ssafy.myhome.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class InterestBoard {

	private int interestSaleId;
	@NonNull
	private String userId;
	@NonNull
	private SaleBoard saleBoard;
	
}
