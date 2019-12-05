package com.example.codeblue.test;

import java.util.Map;

public interface HospitalService {
	public Map<String, Object> getHospitalList(int currentPage, int rowPerPage, String searchWord);
}
