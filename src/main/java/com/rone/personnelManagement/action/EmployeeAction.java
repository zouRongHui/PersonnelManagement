package com.rone.personnelManagement.action;

import com.rone.personnelManagement.bean.Employee;
import com.rone.personnelManagement.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.HashMap;
import java.util.Map;

@SessionAttributes(value="employee", types=Employee.class)
@Controller
public class EmployeeAction {
	
	private EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
//	private DepartmentService departmentService = new DepartmentServiceImpl();
	private NoticeService noticeService = new NoticeServiceImpl();
	private SalaryService salaryService = new SalaryServiceImpl();
	private VacateService vacateService = new VacateServiceImpl();

	@RequestMapping("/showEmployee.do")
	public String showEmployee(@RequestParam(value="pageNumber", required=false) String pageNumber, 
			Map<String, Object> map) {
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("pageNumber", pageNumber);
		System.out.println("EmployeeAction showEmployee.do[" + paramMap + " ]");
		employeeService.showEmployee(paramMap, map);
		return "employee/employee.jsp";
	}
	
	@RequestMapping("/updatePassword.do")
	public String updatePassword(@RequestParam(value="id", required=false) String id, 
			@RequestParam(value="password", required=false) String password,
			Map<String, Object> map) {
		employeeService.updatePassword(id, password, map);
		return "redirect:/showEmployee.do";
	}
	
	
	@RequestMapping("/showVacate.do")
	public String showVacate(@RequestParam(value="id", required=false) String id, 
			@RequestParam(value="pageNumber", required=false) String pageNumber,
			Map<String, Object> map) {
		vacateService.showVacate(id, map, pageNumber);
		return "employee/vacate.jsp";
	}
	
	@RequestMapping("/insertVacate.do")
	public String insertVacate(@RequestParam(value="id", required=false) String id, 
			@RequestParam(value="date", required=false) String date,
			@RequestParam(value="days", required=false) String days,
			@RequestParam(value="reason", required=false) String reason) {
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("id", id);
		paramMap.put("date", date);
		paramMap.put("days", days);
		paramMap.put("reason", reason);
		vacateService.insertVacate(paramMap);
		return "redirect:/showVacate.do?id=" + id;
	}
	
	@RequestMapping("/removeVacate.do")
	public String removeVacate(@RequestParam(value="id", required=false) String id, 
			@RequestParam(value="employeeId", required=false) String employeeId) {
		vacateService.removeVacate(id);
		return "redirect:/showVacate.do?id=" + employeeId;
	}
	
	@RequestMapping("/approveVacate.do")
	public String approveVacate(@RequestParam(value="id", required=false) String id, 
			@RequestParam(value="employeeId", required=false) String employeeId) {
		vacateService.approveVacate(id);
		return "redirect:/showVacate.do?id=" + employeeId;
	}
	
	@RequestMapping("/opposeVacate.do")
	public String opposeVacate(@RequestParam(value="id", required=false) String id, 
			@RequestParam(value="employeeId", required=false) String employeeId) {
		vacateService.opposeVacate(id);
		return "redirect:/showVacate.do?id=" + employeeId;
	}
	
	@RequestMapping("/showNotice.do")
	public String showNotice(@RequestParam(value="pageNumber", required=false) String pageNumber,
			Map<String, Object> map) {
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("pageNumber", pageNumber);
		System.out.println("EmployeeAction showNotice.do[ " + paramMap + " ]");
		noticeService.showNotice(paramMap, map);
		return "employee/notice.jsp";
	}
	
	@RequestMapping("/showSalary.do")
	public String showSalary(@RequestParam(value="month", required=false) String month,
			@RequestParam(value="pageNumber", required=false) String pageNumber,
			Map<String, Object> map) {
		salaryService.showSalary(month, pageNumber, map);
		return "employee/salary.jsp";
	}
	
}
