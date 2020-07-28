package com.erp.test.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.erp.test.dao.EmployeeDAO;
import com.erp.test.dao.impl.EmployeeDAOImpl;
import com.erp.test.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDAO empDAO = new EmployeeDAOImpl();
	@Override
	public Map<String, Object> insertEmployee(Map<String, Object> employee) {
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("msg", "입력 성공");
		if(empDAO.insertEmployee(employee)!=1) {
			rMap.put("msg", "입력 실패");
		}
		return rMap;
	}

	@Override
	public Map<String, Object> updateEmployee(Map<String, Object> employee) {
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("msg", "수정 성공");
		if(empDAO.insertEmployee(employee)!=1) {
			rMap.put("msg", "수정 실패");
		}
		return rMap;
	}

	@Override
	public Map<String, Object> deleteEmployee(Map<String, Object> employee) {
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("msg", "퇴사 성공");
		if(empDAO.insertEmployee(employee)!=1) {
			rMap.put("msg", "퇴사 실패");
		}
		return rMap;
	}

	@Override
	public Map<String, Object> selectEmployee(Map<String, Object> employee) {
		return empDAO.selectEmployee(employee);
	}

	@Override
	public List<Map<String, Object>> selectEmployeeList(Map<String, Object> employee) {
		return empDAO.selectEmployeeList(employee);
	}

	

}