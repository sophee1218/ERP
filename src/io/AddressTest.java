package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.erp.test.common.Conn;

public class AddressTest
{

	public void exePath(String path)
	{
		List<Map<String, String>> abrList = new ArrayList<>();
		File f = new File(path);
		try
		{
			FileInputStream fi = new FileInputStream(f);
			InputStreamReader ips = new InputStreamReader(fi, "MS949");
			BufferedReader br = new BufferedReader(ips);
			StringBuffer sb = new StringBuffer();
			String str = null;
			while ((str = br.readLine()) != null)
			{
				sb.append(str + "<>");
			}
			String key = "dong_code\r\n" + "sido\r\n" + "gugun\r\n" + "dong_name\r\n" + "lee_name\r\n" + "IS_MNT\r\n"
					+ "jibun\r\n" + "sub_jibun\r\n" + "road_code\r\n" + "road_name\r\n" + "is_base\r\n"
					+ "build_num\r\n" + "SUB_BUILD_NUM\r\n" + "BUILDING_NAME\r\n" + "DETAIL_BUILDING_NAME\r\n"
					+ "addr_code";
			String[] keys = key.split("\r\n");
			String[] address = sb.toString().split("<>");
			for (int i = 0; i < address.length; i++)
			{
				Map<String, String> adrMap = new HashMap<>();
				String[] values = address[i].split("\\|");
				for (int j = 0; j < keys.length; j++)
				{
					adrMap.put(keys[j], values[j]);
				}
				abrList.add(adrMap);
			}
			String sql = "insert into address(";
			String value = " values(";
			for (String k : keys)
			{
				sql += k + ",";
				value += "?,";
			}
			sql = sql.substring(0, (sql.length() - 1)) + ")\r\n";
			value = value.substring(0, (value.length() - 1)) + ")";
			sql += value;
			Connection con = Conn.open();
			PreparedStatement ps = con.prepareStatement(sql);

			int cnt = 1;
			for (Map<String, String> row : abrList)
			{
				for (int i = 0; i < keys.length; i++)
				{
					ps.setString((i + 1), row.get(keys[i]));
				}

				ps.addBatch();

				if (cnt % 1000 == 0)
				{

					ps.executeBatch();
					ps.clearBatch();
				}
				cnt++;

			}

			if (abrList.size() % 1000 != 0)
			{

				ps.executeBatch();
				ps.clearBatch();

			}
			con.commit();

		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (UnsupportedEncodingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
