package com.rone.personnelManagement.service;

import com.rone.personnelManagement.bean.Employee;
import com.rone.personnelManagement.bean.Vacate;
import com.rone.personnelManagement.dao.EmployeeDao;
import com.rone.personnelManagement.dao.EmployeeDaoImpl;
import com.rone.personnelManagement.dao.VacateDao;
import com.rone.personnelManagement.dao.VacateDaoImpl;

import java.util.Map;

public class VacateServiceImpl implements VacateService {
	
	private VacateDao vacateDao = new VacateDaoImpl();
	private EmployeeDao employeeDao = new EmployeeDaoImpl();

	@Override
	public void showVacate(String id, Map<String, Object> map, String pageNumber) {
		pageNumber = pageNumber != null ? pageNumber : "1";
		map.put("vacateList", vacateDao.showVacate(id, Integer.parseInt(pageNumber)));
		int count = vacateDao.getCount(id);
		map.put("count", count);
		map.put("pages", (int)Math.ceil(count / 10.0));
		map.put("pageNumber", pageNumber);
	}

	@Override
	public void approveVacate(String id) {
		vacateDao.approveVacate(id);
	}

	@Override
	public void opposeVacate(String id) {
		vacateDao.opposeVacate(id);
	}
	
	@Override
	public void removeVacate(String id) {
		vacateDao.removeVacate(id);
	}
	
	@Override
	public void insertVacate(Map<String, String> paramMap) {
		Vacate vacate = new Vacate();
		vacate.setApprove("未处理");
		vacate.setDays(Integer.parseInt(paramMap.get("days")));
		vacate.setDate(paramMap.get("date"));
		vacate.setReason(paramMap.get("reason"));
		Employee applicant = employeeDao.getEmployee(paramMap.get("id"));
		vacate.setApplicant(applicant);
		vacate.setHandler(applicant.getDepartment().getManager());
		vacateDao.insertVacate(vacate);
	}

}
