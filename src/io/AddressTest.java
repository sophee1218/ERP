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

   public static void main(String[] args)
   {
      String keyStr = "DONG_CODE\r\n" + "SIDO\r\n" + "GUGUN\r\n" + "DONG_NAME\r\n" + "LEE_NAME\r\n" + "IS_MNT\r\n"
            + "JIBUN\r\n" + "SUB_JIBUN\r\n" + "ROAD_CODE\r\n" + "ROAD_NAME\r\n" + "IS_BASE\r\n" + "BUILD_NUM\r\n"
            + "SUB_BUILD_NUM\r\n" + "BUILDING_NAME\r\n" + "DETAIL_BUILDING_NAME\r\n" + "ADDR_CODE";
      String keys[] = keyStr.split("\r\n");

      try
      {
         System.out.println("프로그램 시작");
         BufferedReader br = new BufferedReader(new InputStreamReader(
               new FileInputStream(new File("C:\\java_jeong\\address\\build_sejong.txt")), "MS949"));
         List<Map<String, String>> list = new ArrayList<>();
         String str;
         while ((str = br.readLine()) != null)
         {
            String[] values = str.split("\\|");
            Map<String, String> map = new HashMap<>();
            for (int j = 0; j < keys.length; j++)
            {
               map.put(keys[j], values[j]);
            }
            list.add(map);
         }
         String sql = "insert into address (";
         String value = " values(";
         for (String key : keys)
         {
            sql += key + ",";
            value += "?,";
         }
         sql = sql.substring(0, sql.length() - 1) + ")";
         value = value.substring(0, value.length() - 1) + ")";
         sql = sql + value;
         Connection con = Conn.open();
         PreparedStatement ps = con.prepareStatement(sql);
         for(Map<String,String> row:list)
         {
            for(int i=0;i<keys.length;i++)
            {
               ps.setString((i+1), row.get(keys[i]));
            }
            ps.executeUpdate();
         }
         con.commit();
      } catch (FileNotFoundException e)
      {
         e.printStackTrace();
      } catch (UnsupportedEncodingException e)
      {
         e.printStackTrace();
      } catch (IOException e)
      {
         e.printStackTrace();
      } catch (SQLException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
}