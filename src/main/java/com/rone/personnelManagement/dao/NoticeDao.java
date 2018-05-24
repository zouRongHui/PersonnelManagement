package com.rone.personnelManagement.dao;

import com.rone.personnelManagement.bean.Notice;

import java.util.List;
import java.util.Map;

public interface NoticeDao {

	List<Notice> showNotice(Map<String, String> paramMap, int pageNumber);
	
	int getCount(Map<String, String> paramMap);
	
	void insertNotice(Notice notice);
	
	void removeNotice(Notice notice);
	
	void updateNotice(Map<String, String> paramMap);
	
}
