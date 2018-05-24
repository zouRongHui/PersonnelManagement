package com.rone.personnelManagement.action;

import com.rone.personnelManagement.bean.Employee;
import com.rone.personnelManagement.service.EmployeeService;
import com.rone.personnelManagement.service.EmployeeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@SessionAttributes(value="employee", types=Employee.class)
@Controller
public class LoginAction {

	private EmployeeService employeeService = new EmployeeServiceImpl();
	
	@RequestMapping("/login.do")
	public String login(@RequestParam("name") String name, @RequestParam("password") String password, 
			Map<String, Object> map) throws NoSuchAlgorithmException {
		map.put("tipsName", name);
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("name", name);
		paramMap.put("password", password);
		System.out.println("LoginAction login.do[ " + paramMap + " ]");
		return employeeService.helpLogin(paramMap, map);
	}
	
	@RequestMapping("/loginOut.do")
	public String logOut(Map<String, Object> map) {
		System.out.println("LoginAction loginOut.do");
		Employee employee = new Employee();
		map.put("employee", employee);
		return "redirect:/index.jsp";
	}
	
}
