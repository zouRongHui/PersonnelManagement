package com.rone.personnelManagement.service;

import com.rone.personnelManagement.bean.Employee;

import java.util.Map;

public interface EmployeeService {

	String helpLogin(Map<String, String> paramMap, Map<String, Object> map);
	
	void showEmployee(Map<String, String> paramMap, Map<String, Object> map);

	void insertEmployee(Employee employee, Map<String, Object> map);
	
	void updateEmployee(Map<String, String> paramMap);
	
	void removeEmployee(String id);
	
	void updatePosition(Map<String, String> paramMap);
	
	void updatePassword(String id, String password, Map<String, Object> map);

}
