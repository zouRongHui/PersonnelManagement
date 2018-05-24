package com.rone.personnelManagement.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static Session session;
	private static Transaction transaction;
	
	public static Session beaginHibernate() {
		//1.创建SessionFactory
		//不指定文件名默认是找hibernate.cfg.xml文件
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

		//2.创建Session
		session = sessionFactory.openSession();

		//3.开启事务
		transaction = session.beginTransaction();
		return session;
	}
	
	public static void closeHibernate(Session newSession) {
		session = newSession;
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
}
