package com.rone.personnelManagement.service;

import com.rone.personnelManagement.bean.Notice;
import com.rone.personnelManagement.dao.NoticeDao;
import com.rone.personnelManagement.dao.NoticeDaoImpl;

import java.sql.Date;
import java.util.Map;

public class NoticeServiceImpl implements NoticeService {
	
	private NoticeDao noticeDao = new NoticeDaoImpl();
	
	@Override
	public void showNotice(Map<String, String> paramMap, Map<String, Object> map) {
		String pageNumber = paramMap.get("pageNumber") != null ? paramMap.get("pageNumber") : "1";
		map.put("noticeList", noticeDao.showNotice(paramMap, Integer.parseInt(pageNumber)));
		int count = noticeDao.getCount(paramMap);
		map.put("count", count);
		map.put("pages", (int)Math.ceil(count / 10.0));
		map.put("pageNumber", pageNumber);
	}
	
	@Override
	public void insertNotice(Notice notice) {
		notice.setDate(new Date(new java.util.Date().getTime()));
		noticeDao.insertNotice(notice);
	}
	
	@Override
	public void removeNotice(String id) {
		Notice notice = new Notice();
		notice.setId(Integer.parseInt(id));
		noticeDao.removeNotice(notice);
	}
	
	@Override
	public void updateNotice(Map<String, String> paramMap) {
		noticeDao.updateNotice(paramMap);
	}

}
