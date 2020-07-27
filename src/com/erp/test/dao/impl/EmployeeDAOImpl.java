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
import com.erp.test.dao.EmloyeeDAO;

public class EmployeeDAOImpl implements EmloyeeDAO
{

	@Override
	public int insertEmployee(Map<String, Object> employee)
	{

		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
		con=Conn.open();
		String sql = "insert into employee(emp_no,emp_name, emp_crdat,emp_salary,grd_no) values (seq_emp_no.nextval, ?, sysdate, ?,?)";
		ps.setInt(1, Integer.parseInt("emp_no"));
		ps.setString(2,"emp_name");
		ps.setInt(3,Integer.parseInt("emp_salary"));
		ps.setInt(4, Integer.parseInt("grd_no"));
		ps.setString(5,"emp_active");
		result = ps.executeUpdate();
		con.commit();
		}catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			Conn.close(ps, con);

		}
		return result;
	}

	@Override
	public int updateEmployee(Map<String, Object> employee)
	{
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try
		{
			con = Conn.open();
			String sql = "update employee set emp_name=?, emp_salary=?, grd_no=?, emp_active=? where grd_no=?";
			ps=con.prepareStatement(sql);
			ps.setString();
			
			
		}catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			Conn.close(ps, con);

		}
		return result;
	}

	@Override
	public int deleteEmployee(Map<String, Object> employee)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> selectEmployee(Map<String, Object> employee)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> selectEmployeeList(Map<String, Object> employee)
	{
		List<Map<String,Object>> empList = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try
		{
			con=Conn.open();
			String sql = "select emp_no, emp_name, emp_credat, emp_salary, grd_no, emp_active ";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				Map<String, Object> map = new HashMap<>();
				map.put("emp_no", rs.getInt("emp_no"));
				map.put("emp_name", rs.getString("emp_name"));
				map.put("emp_credat", rs.getInt("emp_credat"));
				map.put("emp_salary", rs.getInt("emp_salary"));
				map.put("grd_no", rs.getInt("grd_no"));
				map.put("emp_active", rs.getString("emp_active"));
				empList.add(map);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			Conn.close(rs,ps,con);
		}
		return empList;
	}

}
