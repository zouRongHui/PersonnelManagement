package com.rone.personnelManagement.service;

import com.rone.personnelManagement.bean.Notice;

import java.util.Map;

public interface NoticeService {

	void showNotice(Map<String, String> paramMap, Map<String, Object> map);
	
	void insertNotice(Notice notice);
	
	void removeNotice(String id);
	
	void updateNotice(Map<String, String> paramMap);
	
}
