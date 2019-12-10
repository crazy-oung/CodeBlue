package com.example.codeblue.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class HospitalForm {
	private int hospitalId;
	private String hospitalName;
	private int hospitalNumber;
	private String hospitalAddress;
	private String hospitalAddress2;
	private Region region;
	private MultipartFile hospitalImg;
}
