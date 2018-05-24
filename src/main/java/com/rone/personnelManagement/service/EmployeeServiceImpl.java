package com.rone.personnelManagement.service;

import com.rone.personnelManagement.bean.Employee;
import com.rone.personnelManagement.dao.DepartmentDao;
import com.rone.personnelManagement.dao.DepartmentDaoImpl;
import com.rone.personnelManagement.dao.EmployeeDao;
import com.rone.personnelManagement.dao.EmployeeDaoImpl;
import com.rone.personnelManagement.util.MyStringUtil;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDao employeeDao = new EmployeeDaoImpl();
	private DepartmentDao departmentDao = new DepartmentDaoImpl();
	
	@Override
	public String helpLogin(Map<String, String> paramMap, Map<String, Object> map) {
		String name = paramMap.get("name");
		String password = paramMap.get("password");
//		try {
//			password = MyStringUtil.encryption(password);
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//		}
		Employee employee = employeeDao.login(name, password);
		if (employee == null) {
			map.put("tip", "* 无该员工的信息");
			return "index.jsp";
		} else {
			map.put("employee", employee);
			if ("管理员".equals(employee.getPosition())) {
				return "redirect:/manager_showEmployee.do";
			} else {
				return "redirect:/showEmployee.do";
			}
		}
	}
	
	@Override
	public void showEmployee(Map<String, String> paramMap, Map<String, Object> map) {
		String pageNumber = paramMap.get("pageNumber") != null ? paramMap.get("pageNumber") : "1";
		map.put("employeeList", employeeDao.showEmployee(paramMap, Integer.parseInt(pageNumber)));
		int count = employeeDao.getCount(paramMap);
		map.put("count", count);
		map.put("pages", (int)Math.ceil(count / 10.0));
		map.put("pageNumber", pageNumber);
		map.put("departmentList", departmentDao.getDepartments());
	}
	
	@Override
	public void insertEmployee(Employee employee, Map<String, Object> map) {
		employeeDao.insertEmployee(employee);
	}
	
	@Override
	public void updateEmployee(Map<String, String> paramMap) {
		employeeDao.updateEmployee(paramMap);
	}
	
	@Override
	public void removeEmployee(String id) {
		Employee employee = new Employee();
		employee.setID(Integer.parseInt(id));
		employeeDao.removeEmployee(employee);
	}
	
	@Override
	public void updatePosition(Map<String, String> paramMap) {
		employeeDao.updatePosition(paramMap);
	}
	
	@Override
	public void updatePassword(String id, String password, Map<String, Object> map) {
		try {
			password = MyStringUtil.encryption(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		Employee employee = employeeDao.updatePassword(id, password);
		map.put("employee", employee);
	}

}
