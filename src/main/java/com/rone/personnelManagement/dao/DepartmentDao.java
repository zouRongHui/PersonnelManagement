package com.rone.personnelManagement.dao;

import com.rone.personnelManagement.bean.Department;

import java.util.List;

public interface DepartmentDao {

	List<Department> getDepartments();
	
	List<Department> showDepartment(int pageNumber);
	
	int getCount();
	
	void insertDepartment(Department department);
	
	void removeDepartment(Department department);

}
