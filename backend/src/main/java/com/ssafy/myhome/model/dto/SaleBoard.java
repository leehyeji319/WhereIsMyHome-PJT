package com.ssafy.myhome.model.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleBoard extends BasePostForm {

	private int boardId;
	private String saleType;
	private String salePrice;
	private String buildingType;
	private String buildingName;
	private String buildingAddress;
	private double buildingSpace; //평수
	private int buildingFloorType; //1 지상, 0 지하
	private double buildingFloor;
	private double buildingRoomNum;
	
	private int commentCnt; //댓글 개수
	
	private List<FileInfo> fileInfos;
	private List<Comment> comments;
	
}
