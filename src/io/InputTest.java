package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class InputTest {

	public static void main(String[] args) {
		File f = new File("c:\\read.txt");
		List<Map<String,String>> pList = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF-8"));
			String str = br.readLine();
			while(str!=null) {
				Map<String,String> phone = new HashMap<>();
				String[] strs = str.split(",");
				phone.put("지역", strs[0]);
				phone.put("국번", strs[1]);
				pList.add(phone);
				str = br.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println(pList);
	}
}

