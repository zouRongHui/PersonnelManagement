package com.rone.personnelManagement.dao;

import com.rone.personnelManagement.bean.Notice;
import com.rone.personnelManagement.util.HibernateUtil;
import com.rone.personnelManagement.util.MyStringUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;
import java.util.Map;

public class NoticeDaoImpl implements NoticeDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Notice> showNotice(Map<String, String> paramMap, int pageNumber) {
		Session session = HibernateUtil.beaginHibernate();
		String hql = this.getHql(paramMap);
		Query query = session.createQuery(hql);
		query.setFirstResult((pageNumber - 1) * 10).setMaxResults(10);
		List<Notice> list = query.list();
		HibernateUtil.closeHibernate(session);
		return list;
	}
	
	@Override
	public int getCount(Map<String, String> paramMap) {
		Session session = HibernateUtil.beaginHibernate();
		String hql = "select count(n)" + this.getHql(paramMap);
		Query query = session.createQuery(hql);
		int i = ((Long) query.uniqueResult()).intValue();
		HibernateUtil.closeHibernate(session);
		return i;
	}
	
	@Override
	public void insertNotice(Notice notice) {
		Session session = HibernateUtil.beaginHibernate();
		session.save(notice);
		HibernateUtil.closeHibernate(session);
	}
	
	@Override
	public void removeNotice(Notice notice) {
		Session session = HibernateUtil.beaginHibernate();
		notice = (Notice) session.get(Notice.class, notice.getId());
		session.delete(notice);
		HibernateUtil.closeHibernate(session);
	}
	
	@Override
	public void updateNotice(Map<String, String> paramMap) {
		Session session = HibernateUtil.beaginHibernate();
		Notice notice = (Notice) session.get(Notice.class, Integer.parseInt(paramMap.get("id")));
		notice.setTitle(paramMap.get("title"));
		notice.setContent(paramMap.get("content"));
		HibernateUtil.closeHibernate(session);
	}
	
	private String getHql(Map<String, String> paramMap) {
		String hql = "from Notice n where 1=1";
		String title = paramMap.get("title") != null ? paramMap.get("title") : "";
		String startDay = paramMap.get("startDay") != null ? paramMap.get("startDay") : "";
		String endDay = paramMap.get("endDay") != null ? paramMap.get("endDay") : "";
		if (!title.equals("")) {
			hql += " and n.title like '" + MyStringUtil.toSQLLike(title) + "'";
		}
		if (!startDay.equals("") & !endDay.equals("")) {
			hql += "and n.date between '" + startDay + "' and '" + endDay + "'";
		} else {
			if (!startDay.equals("") & endDay.equals("")) {
				hql += "and n.date > '" + startDay + "'";
			} else {
				if (startDay.equals("") & !endDay.equals("")) {
					hql += "and n.date < '" + endDay + "'";
				}
			}
		}
		return hql;
	}

}
