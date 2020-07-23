package com.erp.test.service.impl;

import java.util.List;
import java.util.Map;

import com.erp.test.dao.GradeDAO;
import com.erp.test.dao.impl.GradeDAOImpl;
import com.erp.test.service.GradeService;

public class GradeServiceImpl implements GradeService
{
	private GradeDAO gdao = new GradeDAOImpl();
	@Override
	public Map<String, Object> insertGrade(Map<String, Object> grade)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> updateGrade(Map<String, Object> grade)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> deleteGrade(Map<String, Object> grade)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> selectGrade(Map<String, Object> grade)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> selectGradeList(Map<String, Object> grade)
	{
		return gdao.selectGradeList(grade);
	}

}
