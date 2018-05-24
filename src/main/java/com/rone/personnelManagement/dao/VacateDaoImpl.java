package com.rone.personnelManagement.dao;

import com.rone.personnelManagement.bean.Vacate;
import com.rone.personnelManagement.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class VacateDaoImpl implements VacateDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Vacate> showVacate(String id, int pageNumber) {
		Session session = HibernateUtil.beaginHibernate();
		Query query = session.createQuery("from Vacate v where v.applicant = :applicant or v.handler = :handler");
		query.setString("handler", id).setString("applicant", id);
		query.setFirstResult((pageNumber - 1) * 10).setMaxResults(10);
		List<Vacate> list = query.list();
		HibernateUtil.closeHibernate(session);
		return list;
	}
	
	@Override
	public int getCount(String id) {
		Session session = HibernateUtil.beaginHibernate();
		Query query = session.createQuery("select count(v) from Vacate v where v.applicant = :applicant or v.handler = :handler");
		query.setString("handler", id).setString("applicant", id);
		int i = ((Long) query.uniqueResult()).intValue();
		HibernateUtil.closeHibernate(session);
		return i;
	}

	@Override
	public void approveVacate(String id) {
		Session session = HibernateUtil.beaginHibernate();
		Vacate vacate = (Vacate) session.get(Vacate.class, Integer.parseInt(id));
		vacate.setApprove("同意");
		HibernateUtil.closeHibernate(session);
	}

	@Override
	public void opposeVacate(String id) {
		Session session = HibernateUtil.beaginHibernate();
		Vacate vacate = (Vacate) session.get(Vacate.class, Integer.parseInt(id));
		vacate.setApprove("驳回");
		HibernateUtil.closeHibernate(session);
	}

	@Override
	public void removeVacate(String id) {
		Session session = HibernateUtil.beaginHibernate();
		Vacate vacate = (Vacate) session.get(Vacate.class, Integer.parseInt(id));
		session.delete(vacate);
		HibernateUtil.closeHibernate(session);
	}

	@Override
	public void insertVacate(Vacate vacate) {
		Session session = HibernateUtil.beaginHibernate();
		session.save(vacate);
		HibernateUtil.closeHibernate(session);
	}

}
