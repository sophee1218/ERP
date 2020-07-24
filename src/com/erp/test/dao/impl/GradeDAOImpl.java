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
import com.erp.test.dao.GradeDAO;

public class GradeDAOImpl implements GradeDAO
{

	@Override
	public int insertGrade(Map<String, Object> grade)
	{
		Connection con = null;
		PreparedStatement ps = null;
	
		int result = 0;
		try
		{
			con = Conn.open();
			String sql = "insert into(grd_no, grd_name, grd_desc) values(?,?,?) ";
			ps.setString(1, "grd_no");
			ps.setString(2, "grd_name");
			ps.setString(3, "grd_desc");
			result = ps.executeUpdate();

			con.commit();
		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			Conn.close(ps, con);

		}
		return result;
	}

	@Override
	public int updateGrade(Map<String, Object> grade)
	{
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try
		{
			con = Conn.open();
			String sql = "update grade set grd_name=?, grd_desc=? where grd_no=? ";
			ps=con.prepareStatement(sql);
			ps.setString(1, grade.get("grd_name").toString());
			ps.setString(2, grade.get("grd_desc").toString());
			ps.setInt(3, Integer.parseInt(grade.get("grd_no").toString()));
			result = ps.executeUpdate();
			con.commit();
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			Conn.close(ps, con);

		}
		return result;
	}

	@Override
	public int deleteGrade(Map<String, Object> grade)
	{
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
		con = Conn.open();
		String sql = "delete from grade where grd_no = ? ";
		ps=con.prepareStatement(sql);
		ps.setString(1,"grd_no");
		result = ps.executeUpdate();
		
		
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
	public Map<String, Object> selectGrade(Map<String, Object> grade)
	{
	
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try
		{
			con = Conn.open();
			String sql = "select grd_no, grd_name, grd_desc from grade where grd_no=? ";
			ps = con.prepareStatement(sql);
			ps.setInt(1,(int)grade.get("grd_no"));
			
			rs = ps.executeQuery();
			if (rs.next())
				
			{
				Map<String,Object> map = new HashMap<>();
				map.put("grd_no", rs.getInt("grd_no"));
				map.put("grd_name", rs.getString("grd_name"));
				map.put("grd_desc", rs.getString("grd_desc"));
				return map;
				
			}
		}catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			Conn.close(ps, con);

		}
		return null;
	}

	@Override
	public List<Map<String, Object>> selectGradeList(Map<String, Object> grade)
	{
		List<Map<String, Object>> gradeList = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try
		{
			con = Conn.open();
			String sql = "select grd_no, grd_name, grd_desc from grade";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next())
			{
				Map<String, Object> map = new HashMap<>();
				map.put("grd_no", rs.getInt("grd_no"));
				map.put("grd_name", rs.getString("grd_name"));
				map.put("grd_desc", rs.getString("grd_desc"));
				gradeList.add(map);

			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			Conn.close(rs, ps, con);

		}
		return gradeList;
	}

}
