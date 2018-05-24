package com.rone.personnelManagement.dao;

import com.rone.personnelManagement.bean.Salary;

import java.util.List;
import java.util.Map;

public interface SalaryDao {

	List<Salary> showSalary(String month, int pageNumber);
	
	int getCout(String month);
	
	void insertSalary(String month);
	
	void updateSalary(Map<String, String> paramMap);
	
}
