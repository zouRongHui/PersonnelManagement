package com.rone.personnelManagement.dao;

import com.rone.personnelManagement.bean.Employee;

import java.util.List;
import java.util.Map;


public interface EmployeeDao {

	Employee login(String name, String password);
	
	List<Employee> showEmployee(Map<String, String> paramMap, int pageNumber);
	
	int getCount(Map<String, String> paramMap);

	void insertEmployee(Employee employee);
	
	void updateEmployee(Map<String, String> paramMap);
	
	void removeEmployee(Employee employee);
	
	void updatePosition(Map<String, String> paramMap);
	
	Employee updatePassword(String id, String password);
	
	Employee getEmployee(String id);
	
}
