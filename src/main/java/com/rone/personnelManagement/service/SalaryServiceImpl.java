package com.rone.personnelManagement.service;

import com.rone.personnelManagement.dao.SalaryDao;
import com.rone.personnelManagement.dao.SalaryDaoImpl;

import java.sql.Date;
import java.util.Map;

public class SalaryServiceImpl implements SalaryService {
	
	private SalaryDao salaryDao = new SalaryDaoImpl();
	
	@Override
	public void showSalary(String month, String pageNumber, Map<String, Object> map) {
		month = month != null ? month : "";
		if(month.isEmpty()) {
			month = new Date(new java.util.Date().getTime()).toString().substring(0, 7);
		} else {
			month = month.substring(0, 7);
		}
		month += "%";
		pageNumber = pageNumber != null ? pageNumber : "1";
		map.put("salaryList", salaryDao.showSalary(month, Integer.parseInt(pageNumber)));
		int count = salaryDao.getCout(month);
		map.put("count", count);
		map.put("pages", (int)Math.ceil(count / 10.0));
		map.put("pageNumber", pageNumber);
	}
	
	@Override
	public void insertSalary() {
		String month = new Date(new java.util.Date().getTime()).toString().substring(0, 7) + "%";
		salaryDao.insertSalary(month);
	}
	
	@Override
	public void updateSalary(Map<String, String> paramMap) {
		salaryDao.updateSalary(paramMap);
	}

}
