package com.example.codeblue.board.vo;

import lombok.Data;

@Data
public class ReportHistory {
	private int reportHistoryId;
	private String reportTitle;
	private String reportContent;
	private String reportDatetime;
	private Report report;
}