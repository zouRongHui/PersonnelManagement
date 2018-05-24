package com.rone.personnelManagement.service;

import java.util.Map;


public interface DepartmentService {

	void showDepartment(Map<String, Object> map, String pageNumber);
	
	void insertDepartment(String name);
	
	void removeDepartment(String id);
	
}
