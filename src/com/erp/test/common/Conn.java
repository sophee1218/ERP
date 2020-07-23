package com.erp.test.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conn
{
	static
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	public static Connection open()
	{
		try
		{
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "c##test", "test");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static void close(ResultSet rs)
	{
		if (rs != null)
		{
			try
			{
				rs.close();

			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

	public static void close(Connection con)
	{
		if (con != null)
		{
			try
			{
				con.close();

			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

	public static void close(PreparedStatement ps)
	{
		if (ps != null)
		{
			try
			{
				ps.close();

			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

	public static void close(PreparedStatement ps, Connection con)
	{
		close(ps);
		close(con);
	}

	public static void close(ResultSet rs, PreparedStatement ps, Connection con)
	{
		close(rs);
		close(ps);
		close(con);
	}
}
