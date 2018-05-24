package com.rone.personnel_management.test;

import com.rone.personnelManagement.bean.Department;
import com.rone.personnelManagement.bean.Employee;
import com.rone.personnelManagement.bean.Notice;
import com.rone.personnelManagement.bean.Vacate;
import com.rone.personnelManagement.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.*;

import java.sql.Date;

public class HibernateTest {
	
	Configuration configuration;
	ServiceRegistry serviceRegistry;
	SessionFactory sessionFactory;
	Session session;
	Transaction transaction;
	
	Logger log = Logger.getLogger(this.getClass());

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		session = HibernateUtil.beaginHibernate();
	}

	@After
	public void tearDown() throws Exception {
		HibernateUtil.closeHibernate(session);
	}

	@Test
	public void testDepartment() {
		Department dep = new Department("人事部");
		session.save(dep);
	}

	@Test
	public void testEmployee() {
		Department dep = session.get(Department.class, 1);
		Employee emp = new Employee("rone", "670b14728ad9902aecba32e22fa4f6bd", "男", "汉", "18015564912"
				, "rone@rone.com", "江苏", "文正学院", "本科", dep, "管理员"
				, new Date(new java.util.Date().getTime()), "吴中大道1188号", "未婚", "320981199412272997");
		session.save(emp);
	}
	
	@Test
	public void testNotice() {
		Notice no = new Notice( "开业公告", "公司成立了啊！");
		session.save(no);
	}
	
	@Test
	public void testVacate() {
		Employee emp = session.get(Employee.class, 1);
		Vacate vac = new Vacate("reason", emp, emp, "2015-05-01", 3, "未处理");
		session.save(vac);
	}

	@Test
	public void testSalary() {
//		Employee emp = (Employee) session.get(Employee.class, 1);
//		Salary sal = new Salary(emp);
//		session.save(sal);
	}
	
	@Test
	public void test() {
		Employee emp = session.get(Employee.class, 1);
		emp.setNativePlace("江苏东台");
		session.update(emp);
		log.error(emp.toString());
//		System.out.println(emp.toString());
	}
	
	@Test
	public void testGetCount() {
		Session session = HibernateUtil.beaginHibernate();
		Query query = session.createQuery("select count(e) from Employee e");
		int i = ((Long) query.uniqueResult()).intValue();
		System.out.println(i);
	}
	
	@Test
	public void testHql() {
		Session session = HibernateUtil.beaginHibernate();
		Query query = session.createQuery("select count(e) from Employee e where e.id = :id");
		query.setString("id", "1");
		Employee employee = (Employee) query.uniqueResult();
		System.out.println(employee);
	}
	
}
