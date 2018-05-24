package com.rone.personnelManagement.action;

import com.rone.personnelManagement.bean.Department;
import com.rone.personnelManagement.bean.Employee;
import com.rone.personnelManagement.bean.Notice;
import com.rone.personnelManagement.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ManagerAction {

	private EmployeeService employeeService = new EmployeeServiceImpl();
	private DepartmentService departmentService = new DepartmentServiceImpl();
	private NoticeService noticeService = new NoticeServiceImpl();
	private SalaryService salaryService = new SalaryServiceImpl();


	@RequestMapping("/manager_showEmployee.do")
	public String showEmployee(@RequestParam(value="name", required=false) String name, 
			@RequestParam(value="phone", required=false) String phone, 
			@RequestParam(value="department", required=false) String department, 
			@RequestParam(value="sex", required=false) String sex, 
			@RequestParam(value="startDay", required=false) String startDay, 
			@RequestParam(value="endDay", required=false) String endDay, 
			@RequestParam(value="pageNumber", required=false) String pageNumber, Map<String, Object> map) {
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("name", name);
		paramMap.put("phone", phone);
		paramMap.put("department", department);
		paramMap.put("sex", sex);
		paramMap.put("startDay", startDay);
		paramMap.put("endDay", endDay);
		paramMap.put("pageNumber", pageNumber);
		System.out.println("ManagerAction manager_showEmployee.do[" + paramMap + " ]");
		employeeService.showEmployee(paramMap, map);
		return "manager/employee.jsp";
	}
	
	@RequestMapping("/manager_insertEmployee.do")
	public String insertEmployee(@RequestParam(value="name") String name, 
			@RequestParam(value="sex") String sex, 
			@RequestParam(value="national") String national, 
			@RequestParam(value="phone") String phone, 
			@RequestParam(value="email") String email, 
			@RequestParam(value="nativePlace") String nativePlace, 
			@RequestParam(value="graduateSchool") String graduateSchool, 
			@RequestParam(value="education") String education, 
			@RequestParam(value="department") String department_name, 
			@RequestParam(value="position") String position, 
			@RequestParam(value="address") String address, 
			@RequestParam(value="maritalStatus") String maritalStatus, 
			@RequestParam(value="IDCardNumber") String iDCardNumber, 
			Map<String, Object> map){
		Department department = new Department(department_name);
		Employee employee = new Employee(name, sex, national, phone, email, nativePlace, graduateSchool, education, department, position, address, maritalStatus, iDCardNumber);
		System.out.println("ManagerAction manager_insertEmployee.do[" + employee + " ]");
		employeeService.insertEmployee(employee, map);
		return "redirect:/manager_showEmployee.do";
	}
	
	@RequestMapping("manager_updateEmployee.do")
	public String updateEmployee(@RequestParam(value="id") String id, 
			@RequestParam(value="sex") String sex,
			@RequestParam(value="national") String national,
			@RequestParam(value="phone") String phone,
			@RequestParam(value="email") String email,
			@RequestParam(value="nativePlace") String nativePlace,
			@RequestParam(value="graduateSchool") String graduateSchool,
			@RequestParam(value="education") String education,
			@RequestParam(value="address") String address,
			@RequestParam(value="maritalStatus") String maritalStatus,
			@RequestParam(value="IDCardNumber") String IDCardNumber) {
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("id", id);
		paramMap.put("sex", sex);
		paramMap.put("national", national);
		paramMap.put("phone", phone);
		paramMap.put("email", email);
		paramMap.put("nativePlace", nativePlace);
		paramMap.put("graduateSchool", graduateSchool);
		paramMap.put("education", education);
		paramMap.put("address", address);
		paramMap.put("maritalStatus", maritalStatus);
		paramMap.put("IDCardNumber", IDCardNumber);
		System.out.println("ManagerAction manager_updateEmployee.do[ " + paramMap + " ]");
		employeeService.updateEmployee(paramMap);
		return "redirect:/manager_showEmployee.do";
	}
	
	
	@RequestMapping("/manager_showDepartment.do")
	public String showDepartment(@RequestParam(value="pageNumber", required=false) String pageNumber, 
			Map<String, Object> map) {
		departmentService.showDepartment(map, pageNumber);
		return "manager/department.jsp";
	}
	
	@RequestMapping("/manager_insertDepartment.do")
	public String insertDepartment(@RequestParam("name") String name) {
		departmentService.insertDepartment(name);
		return "redirect:/manager_showDepartment.do";
	}
	
	@RequestMapping("/manager_removeDepartment.do")
	public String removeDepartment(@RequestParam(value="id") String id) {
		departmentService.removeDepartment(id);
		return "redirect:/manager_showDepartment.do";
	}
		
	@RequestMapping("/manager_showNotice.do")
	public String showNotice(@RequestParam(value="title", required=false) String title, 
			@RequestParam(value="startDay", required=false) String startDay, 
			@RequestParam(value="endDay", required=false) String endDay,
			@RequestParam(value="pageNumber", required=false) String pageNumber,
			Map<String, Object> map) {
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("title", title);
		paramMap.put("startDay", startDay);
		paramMap.put("endDay", endDay);
		paramMap.put("pageNumber", pageNumber);
		System.out.println("ManagerAction manager_showNotice.do[" + paramMap + " ]");
		noticeService.showNotice(paramMap, map);
		return "manager/notice.jsp";
	}
	
	@RequestMapping("/manager_insertNotice.do")
	public String insertNotice(Notice notice) {
		noticeService.insertNotice(notice);
		return "redirect:/manager_showNotice.do";
	}
	
	@RequestMapping("/manager_removeNotice.do")
	public String deleteNotice(@RequestParam(value="id") String id) {
		noticeService.removeNotice(id);
		return "redirect:/manager_showNotice.do";
	}
	
	@RequestMapping("/manager_updateNotice.do")
	public String updateNotice(@RequestParam(value="id") String id, 
			@RequestParam(value="title") String title, 
			@RequestParam(value="content") String content) {
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("id", id);
		paramMap.put("title", title);
		paramMap.put("content", content);
		System.out.println("ManagerAction manager_updateNotice.do[ " + paramMap + " ]");
		noticeService.updateNotice(paramMap);
		return "redirect:/manager_showNotice.do";
	}
	
	@RequestMapping("/manager_showSalary.do")
	public String showSalary(@RequestParam(value="month", required=false) String month,
			@RequestParam(value="pageNumber", required=false) String pageNumber,
			Map<String, Object> map) {
		salaryService.showSalary(month, pageNumber, map);
		return "manager/salary.jsp";
	}
	
	@RequestMapping("/manager_insertSalary.do")
	public String insertSalary(){
		salaryService.insertSalary();
		return "redirect:/manager_showSalary.do";
	}
	
	@RequestMapping("/manager_updateSalary.do")
	public String updateSalary(@RequestParam(value="id") String id, 
			@RequestParam(value="days") String days, 
			@RequestParam(value="salary") String salary,
			@RequestParam(value="bonus") String bonus, 
			@RequestParam(value="overtimePay") String overtimePay){
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("id", id);
		paramMap.put("days", days);
		paramMap.put("salary", salary);
		paramMap.put("bonus", bonus);
		paramMap.put("overtimePay", overtimePay);
		salaryService.updateSalary(paramMap);
		return "redirect:/manager_showSalary.do";
	}
	
	@RequestMapping("/manager_showPosition.do")
	public String showPosition(@RequestParam(value="name", required=false) String name, 
			@RequestParam(value="department", required=false) String department, 
			@RequestParam(value="pageNumber", required=false) String pageNumber, 
			Map<String, Object> map) {
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("name", name);
		paramMap.put("department", department);
		paramMap.put("pageNumber", pageNumber);
		System.out.println("ManagerAction manager_showPosition.do[" + paramMap + " ]");
		employeeService.showEmployee(paramMap, map);
		return "manager/redeploy.jsp";
	}
	
	@RequestMapping("manager_removeEmployee.do")
	public String deleteEmployee(@RequestParam(value="id") String id) {
		employeeService.removeEmployee(id);
		return "redirect:/manager_showPosition.do";
	}
	
	@RequestMapping("/manager_updatePosition.do")
	public String updatePosition(@RequestParam(value="id") String id, 
			@RequestParam(value="department") String department, 
			@RequestParam(value="position") String position) {
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("id", id);
		paramMap.put("department", department);
		paramMap.put("position", position);
		employeeService.updatePosition(paramMap);
		return "redirect:/manager_showPosition.do";
	}
	
	
}
