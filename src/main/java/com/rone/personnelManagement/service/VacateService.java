package com.rone.personnelManagement.service;

import java.util.Map;

public interface VacateService {
	
	void showVacate(String id, Map<String, Object> map, String pageNumber);
	
	void approveVacate(String id);
	
	void opposeVacate(String id);
	
	void removeVacate(String id);
	
	void insertVacate(Map<String, String> paramMap);

}
