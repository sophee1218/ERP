package com.erp.test.dao;

import java.util.List;
import java.util.Map;

public interface GradeDAO
{
	int insertGrade(Map<String,Object> grade);
	int updateGrade(Map<String,Object> grade);
	int deleteGrade(Map<String,Object> grade);
	Map<String,Object> selectGrade(Map<String,Object> grade);
	List<Map<String,Object>> selectGradeList(Map<String,Object> grade);
}
