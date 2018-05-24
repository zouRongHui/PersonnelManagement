package com.rone.personnelManagement.service;

import java.util.Map;


public interface SalaryService {

	void showSalary(String month, String pageNumber, Map<String, Object> map);
	
	void insertSalary();
	
	void updateSalary(Map<String, String> paramMap);
}
