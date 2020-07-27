package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputTest
{
	public static void main(String[] args)
	{
		File f = new File("c:\\read.txt");
		try
		{
			FileInputStream fis = new FileInputStream(f);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String str = br.readLine();
			String addrs = "";
			List<Map<String, String>> phoneList = new ArrayList<>();

			while (str != null)
			{
				Map<String, String> phone = new HashMap<>();
				String[] strs = str.split(",");
				phone.put("지역", strs[0]);
				phone.put("국번", strs[1]);
				str = br.readLine();
				phoneList.add(phone);
			}
			System.out.println(phoneList);
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
