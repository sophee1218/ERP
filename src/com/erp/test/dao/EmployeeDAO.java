package com.erp.test.dao;

import java.util.List;
import java.util.Map;

public interface EmployeeDAO
{
	int insertEmployee(Map<String,Object> grade);
	int updateEmployee(Map<String,Object> grade);
	int deleteEmployee(Map<String,Object> grade);
	Map<String,Object> selectEmployee(Map<String,Object> grade);
	List<Map<String,Object>> selectEmployeeList(Map<String,Object> grade);
}
