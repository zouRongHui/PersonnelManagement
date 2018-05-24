package com.rone.personnelManagement.dao;

import com.rone.personnelManagement.bean.Department;
import com.rone.personnelManagement.bean.Employee;
import com.rone.personnelManagement.bean.Salary;
import com.rone.personnelManagement.bean.Vacate;
import com.rone.personnelManagement.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public class EmployeeDaoImpl implements EmployeeDao {
	
	@Override
	public Employee login(String name, String password) {
		String hql = "from Employee e where e.name = :name and e.password = :password";
		Session session = HibernateUtil.beaginHibernate();
		Query query = session.createQuery(hql);
		query.setString("name", name).setString("password", password);
		Employee employee = (Employee) query.uniqueResult();
		HibernateUtil.closeHibernate(session);
		return employee; 
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> showEmployee(Map<String, String> paramMap, int pageNumber) {
		Session session = HibernateUtil.beaginHibernate();
		String hql = "";
		if (paramMap.isEmpty()) {
			hql = "from Employee e";
		} else {
			hql = this.getHql(paramMap, session);
		}
		Query query = session.createQuery(hql);
		query.setFirstResult((pageNumber - 1) * 10).setMaxResults(10);
		List<Employee> list = query.list();
		HibernateUtil.closeHibernate(session);
		return list;
	}
	
	@Override
	public int getCount(Map<String, String> paramMap) {
		Session session = HibernateUtil.beaginHibernate();
		String hql = "";
		if (paramMap.isEmpty()) {
			hql = "select count(e) from Employee e";
		} else {
			hql = "select count(e)" + this.getHql(paramMap, session);
		}
		Query query = session.createQuery(hql);
		int i = ((Long) query.uniqueResult()).intValue();
		HibernateUtil.closeHibernate(session);
		return i;
	}
	
	@Override
	public void insertEmployee(Employee employee) {
		Session session = HibernateUtil.beaginHibernate();
		Department department = employee.getDepartment();
		Query query = session.createQuery("from Department d where d.name = :name");
		query.setString("name", department.getName());
		department = (Department) query.uniqueResult();
		employee.setDepartment(department);
		employee.setPassword("670b14728ad9902aecba32e22fa4f6bd");
		employee.setHireDate(new Date(new java.util.Date().getTime()));
		session.save(employee);
		HibernateUtil.closeHibernate(session);
	}
	
	@Override
	public void updateEmployee(Map<String, String> paramMap) {
		Session session = HibernateUtil.beaginHibernate();
		Employee employee = (Employee) session.get(Employee.class, Integer.parseInt(paramMap.get("id")));
		employee.setSex(paramMap.get("sex"));
		employee.setNational(paramMap.get("national"));
		employee.setPhone(paramMap.get("phone"));
		employee.setEmail(paramMap.get("email"));
		employee.setNativePlace(paramMap.get("nativePlace"));
		employee.setGraduateSchool(paramMap.get("graduateSchool"));
		employee.setEducation(paramMap.get("education"));
		employee.setAddress(paramMap.get("address"));
		employee.setMaritalStatus(paramMap.get("maritalStatus"));
		employee.setIDCardNumber(paramMap.get("IDCardNumber"));
		HibernateUtil.closeHibernate(session);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void removeEmployee(Employee employee) {
		Session session = HibernateUtil.beaginHibernate();
		employee = (Employee) session.get(Employee.class, employee.getID());
		Query query = session.createQuery("from Department d where d.manager = :manager");
		query.setString("manager", employee.getID()+"");
		List<Department> listDepartment = query.list();
		for (Department dep : listDepartment) {
			dep.setManager(null);
		}
		session.flush();
		query = session.createQuery("from Salary s where s.employee = :employee");
		query.setString("employee", employee.getID()+"");
		List<Salary> listSalary = query.list();
		for (Salary sal : listSalary) {
			session.delete(sal);
		}
		session.flush();
		query = session.createQuery("from Vacate v where v.applicant = :applicant");
		query.setString("applicant", employee.getID()+"");
		List<Vacate> listVacate = query.list();
		for (Vacate vac : listVacate) {
			session.delete(vac);
		}
		session.flush();
		query = session.createQuery("from Vacate v where v.handler = :handler");
		query.setString("handler", employee.getID()+"");
		listVacate = query.list();
		for (Vacate vac : listVacate) {
			session.delete(vac);
		}
		session.flush();
		session.delete(employee);
		HibernateUtil.closeHibernate(session);
	}
	
	@Override
	public void updatePosition(Map<String, String> paramMap) {
		Session session = HibernateUtil.beaginHibernate();
		Employee employee = (Employee) session.get(Employee.class, Integer.parseInt(paramMap.get("id")));
		Query query = session.createQuery("from Department d where d.name = :department");
		query.setString("department", paramMap.get("department"));
		Department department = (Department) query.uniqueResult();
		employee.setDepartment(department);
		employee.setPosition(paramMap.get("position"));
		if (paramMap.get("position").equals("经理")){
			if (department.getManager() != null) {
				department.getManager().setPosition("员工");
			}
			department.setManager(employee);
		}
		HibernateUtil.closeHibernate(session);
	}
	
	@Override
	public Employee updatePassword(String id, String password) {
		Session session = HibernateUtil.beaginHibernate();
		Employee employee = (Employee) session.get(Employee.class, Integer.parseInt(id));
		employee.setPassword(password);
		HibernateUtil.closeHibernate(session);
		return employee;
	}
	
	@Override
	public Employee getEmployee(String id) {
		Session session = HibernateUtil.beaginHibernate();
		Employee employee = (Employee) session.get(Employee.class, Integer.parseInt(id));
		HibernateUtil.closeHibernate(session);
		return employee;
	}
	
	public String getHql(Map<String, String> paramMap, Session session) {
		String name = paramMap.get("name") != null ? paramMap.get("name") : "";
		String phone = paramMap.get("phone") != null ? paramMap.get("phone") : "";
		String department = paramMap.get("department") != null ? paramMap.get("department") : "";
		String sex = paramMap.get("sex") != null ? paramMap.get("sex") : "";
		String startDay = paramMap.get("startDay") != null ? paramMap.get("startDay") : "";
		String endDay = paramMap.get("endDay") != null ? paramMap.get("endDay") : "";
		String hql = "from Employee e where 1=1";
		if (!name.equals("")) {
			hql += "and e.name = '" + name + "'";
		}
		if (!phone.equals("")) {
			hql += "and e.phone = '" + phone + "'";
		}
		if (!department.equals("")) {
			Query queryDepartment = session.createQuery("from Department d where d.name = :name");
			queryDepartment.setString("name", department);
			hql += "and e.department = '" + ((Department)queryDepartment.uniqueResult()).getId() + "'";
		}
		if (!sex.equals("")) {
			hql += "and e.sex = '" + sex + "'";
		}
		if (!startDay.equals("") & !endDay.equals("")) {
			hql += "and e.hireDate between '" + startDay + "' and '" + endDay + "'";
		} else {
			if (!startDay.equals("") & endDay.equals("")) {
				hql += "and e.hireDate > '" + startDay + "'";
			} else {
				if (startDay.equals("") & !endDay.equals("")) {
					hql += "and e.hireDate < '" + endDay + "'";
				}
			}
		}
		return hql;
	}
	
}
