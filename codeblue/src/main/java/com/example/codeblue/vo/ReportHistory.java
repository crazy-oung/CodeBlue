package com.example.codeblue.vo;

import lombok.Data;

@Data
public class ReportHistory {
	private int reportHistoryId;
	private String reportTitle;
	private String reportContent;
	private String reportDatetime;
	private Report report;
	private User user;
}