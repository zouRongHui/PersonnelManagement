package com.rone.personnelManagement.dao;

import com.rone.personnelManagement.bean.Department;
import com.rone.personnelManagement.bean.Employee;
import com.rone.personnelManagement.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getDepartments() {
		Session session = HibernateUtil.beaginHibernate();
		Query query = session.createQuery("from Department");
		List<Department> list = query.list();
		HibernateUtil.closeHibernate(session);
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Department> showDepartment(int pageNumber) {
		Session session = HibernateUtil.beaginHibernate();
		Query query = session.createQuery("from Department");
		query.setFirstResult((pageNumber - 1) * 10).setMaxResults(10);
		List<Department> list = query.list();
		HibernateUtil.closeHibernate(session);
		return list;
	}
	
	@Override
	public int getCount() {
		Session session = HibernateUtil.beaginHibernate();
		Query query = session.createQuery("select count(d) from Department d");
		int i = ((Long) query.uniqueResult()).intValue();
		HibernateUtil.closeHibernate(session);
		return i;
	}
	
	@Override
	public void insertDepartment(Department department) {
		Session session = HibernateUtil.beaginHibernate();
		session.save(department);
		HibernateUtil.closeHibernate(session);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void removeDepartment(Department department) {
		Session session = HibernateUtil.beaginHibernate();
		department = (Department) session.get(Department.class, department.getId());
		Query query = session.createQuery("from Employee e where e.department = :department");
		query.setString("department", department.getId()+"");
		List<Employee> listEmployee = query.list();
		for (Employee emp : listEmployee) {
			emp.setDepartment(null);
		}
		session.flush();
		session.delete(department);
		HibernateUtil.closeHibernate(session);
	}

}
