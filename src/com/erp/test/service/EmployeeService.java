package com.erp.test.service;

import java.util.List;
import java.util.Map;

public interface EmployeeService
{
	Map<String,Object> inserEmployee(Map<String,Object> grade);
	Map<String,Object> updateEmployee(Map<String,Object> grade);
	Map<String,Object> deleteEmployee(Map<String,Object> grade);
	Map<String,Object> selectEmployee(Map<String,Object> grade);
	List<Map<String,Object>> selectEmployeeList(Map<String,Object> grade);
}
