package com.erp.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.erp.test.common.Conn;

import com.erp.test.dao.EmployeeDAO;

public class EmployeeDAOImpl implements EmployeeDAO {

	public int insertEmployee(Map<String, Object> employee) {

		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = Conn.open();
			String sql = "insert into employee(emp_no,emp_name, emp_credat,emp_salary,grd_no)"
					+ " values(seq_emp_no.nextval,?,sysdate,?,?)";
			ps = con.prepareStatement(sql);
			ps.setObject(1,employee.get("emp_name"));
			ps.setObject(2,employee.get("emp_salary"));
			ps.setObject(3,employee.get("grd_no"));
			result = ps.executeUpdate();
			con.commit();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			Conn.close(ps,con);
		}
		return result;
	}

	@Override
	public int updateEmployee(Map<String, Object> employee) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = Conn.open();
			String sql = "update employee set "
					+ " emp_name=?,"
					+ " emp_salary=?,"
					+ " grd_no=?"
					+ " where emp_no=?";
			ps = con.prepareStatement(sql);
			ps.setObject(1,employee.get("emp_name"));
			ps.setObject(2,employee.get("emp_salary"));
			ps.setObject(3,employee.get("grd_no"));
			ps.setObject(4,employee.get("emp_no"));
			result = ps.executeUpdate();
			con.commit();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			Conn.close(ps,con);
		}
		return result;
	}

	@Override
	public int deleteEmployee(Map<String, Object> employee) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = Conn.open();
			String sql = "update employee set "
					+ " emp_actvie=0"
					+ " where emp_no=?";
			ps = con.prepareStatement(sql);
			ps.setObject(1,employee.get("emp_no"));
			result = ps.executeUpdate();
			con.commit();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			Conn.close(ps,con);
		}
		return result;
	}

	@Override
	public Map<String, Object> selectEmployee(Map<String, Object> employee) {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = Conn.open();
			String sql = "select emp_no,emp_name, emp_credat,emp_salary,grd_no,emp_active  from employee where emp_no=?";
			ps = con.prepareStatement(sql);
			ps.setObject(1, employee.get("emp_no"));
			rs = ps.executeQuery();
			if(rs.next()) {
				Map<String,Object> g = new HashMap<>();
				g.put("emp_no", rs.getInt("emp_no"));
				g.put("emp_name", rs.getString("emp_name"));
				g.put("emp_credat", rs.getString("emp_credat"));
				g.put("emp_salary", rs.getString("emp_salary"));
				g.put("grd_no", rs.getString("grd_no"));
				g.put("emp_active", rs.getString("emp_active"));
				return g;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			Conn.close(rs,ps,con);
		}
		return null;
	}

	@Override
	public List<Map<String, Object>> selectEmployeeList(Map<String, Object> employee) {
		List<Map<String,Object>> employeeList = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = Conn.open();
			String sql = "select emp_no,emp_name, emp_credat,emp_salary,grd_no,emp_active  from employee";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Map<String,Object> g = new HashMap<>();
				g.put("emp_no", rs.getInt("emp_no"));
				g.put("emp_name", rs.getString("emp_name"));
				g.put("emp_credat", rs.getString("emp_credat"));
				g.put("emp_salary", rs.getString("emp_salary"));
				g.put("grd_no", rs.getString("grd_no"));
				g.put("emp_active", rs.getString("emp_active"));
				employeeList.add(g);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			Conn.close(rs,ps,con);
		}
		return employeeList;
	}
	
	public static void main(String[] args) {
		EmployeeDAO eDao = new EmployeeDAOImpl();
		Map<String,Object> em = new HashMap<>();
		em.put("emp_no", 201);
		System.out.println(eDao.selectEmployee(em));
	}
}
