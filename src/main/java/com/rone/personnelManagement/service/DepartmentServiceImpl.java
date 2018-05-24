package com.rone.personnelManagement.service;

import com.rone.personnelManagement.bean.Department;
import com.rone.personnelManagement.dao.DepartmentDao;
import com.rone.personnelManagement.dao.DepartmentDaoImpl;

import java.util.Map;

public class DepartmentServiceImpl implements DepartmentService {
	
	private DepartmentDao departmentDao = new DepartmentDaoImpl();
	
	@Override
	public void showDepartment(Map<String, Object> map, String pageNumber) {
		pageNumber = pageNumber != null ? pageNumber : "1";
		map.put("departmentList", departmentDao.showDepartment(Integer.parseInt(pageNumber)));
		int count = departmentDao.getCount();
		map.put("count", count);
		map.put("pages", (int)Math.ceil(count / 10.0));
		map.put("pageNumber", pageNumber);
	}
	
	@Override
	public void insertDepartment(String name) {
		Department department = new Department(name);
		departmentDao.insertDepartment(department);
	}
	
	@Override
	public void removeDepartment(String id) {
		Department department = new Department();
		department.setId(Integer.parseInt(id));
		departmentDao.removeDepartment(department);
	}

}
