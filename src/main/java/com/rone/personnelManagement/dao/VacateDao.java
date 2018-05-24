package com.rone.personnelManagement.dao;

import com.rone.personnelManagement.bean.Vacate;

import java.util.List;

public interface VacateDao {

	List<Vacate> showVacate(String id, int pageNumber);
	
	int getCount(String id);
	
	void approveVacate(String id);
	
	void opposeVacate(String id);
	
	void removeVacate(String id);
	
	void insertVacate(Vacate vacate);
	
}
