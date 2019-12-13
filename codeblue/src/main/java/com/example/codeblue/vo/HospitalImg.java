package com.example.codeblue.vo;

import lombok.Data;

@Data
public class HospitalImg {
	private int hospitalImgId;
	private String hospitalImgName;
	private String hospitalImgExtension;
	private String hospitalImgOriginName;
	private long hospitalImgSize;
	private String hospitalImgDatetime;
}