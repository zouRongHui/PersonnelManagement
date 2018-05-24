package com.rone.personnelManagement.dao;

import com.rone.personnelManagement.bean.Employee;
import com.rone.personnelManagement.bean.Salary;
import com.rone.personnelManagement.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public class SalaryDaoImpl implements SalaryDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Salary> showSalary(String month, int pageNumber) {
		Session session = HibernateUtil.beaginHibernate();
		String hql = "from Salary s where s.date like :month";
		Query<Salary> query = session.createQuery(hql);
		query.setString("month", month);
		query.setFirstResult((pageNumber - 1) * 10).setMaxResults(10);
		List<Salary> list = query.list();
		HibernateUtil.closeHibernate(session);
		return list;
	}
	
	@Override
	public int getCout(String month) {
		Session session = HibernateUtil.beaginHibernate();
		Query query = session.createQuery("select count(s) from Salary s where s.date like :month");
		query.setString("month", month);
		int i = ((Long) query.uniqueResult()).intValue();
		HibernateUtil.closeHibernate(session);
		return i;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void insertSalary(String month) {
		Session session = HibernateUtil.beaginHibernate();
		String hql = "from Salary s where s.date like :month";
		Query query = session.createQuery(hql);
		query.setString("month", month);
		if (query.list().size() > 0) {
			return;
		}
		hql = "from Employee e";
		query = session.createQuery(hql);
		List<Employee> employeeList = query.list();
		for (Employee emp : employeeList) {
			Salary salary = new Salary(emp, new Date(new java.util.Date().getTime()));
			session.save(salary);
			session.flush();
		}
		HibernateUtil.closeHibernate(session);
	}
	
	@Override
	public void updateSalary(Map<String, String> paramMap) {
		Session session = HibernateUtil.beaginHibernate();
		Salary salary = (Salary) session.get(Salary.class, Integer.parseInt(paramMap.get("id")));
		salary.setDays(Integer.parseInt(paramMap.get("days")));
		salary.setSalary(Double.parseDouble(paramMap.get("salary")));
		salary.setBonus(Double.parseDouble(paramMap.get("bonus")));
		salary.setOvertimePay(Double.parseDouble(paramMap.get("overtimePay")));
		HibernateUtil.closeHibernate(session);
	}

}
