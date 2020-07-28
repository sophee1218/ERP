package io;

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

public class ReadText {
	public static String readText(String path,String encoding) {
		File f = new File(path);
		try {
			FileInputStream fis = new FileInputStream(f);
			InputStreamReader isr = new InputStreamReader(fis,encoding);
			BufferedReader br = new BufferedReader(isr);
			StringBuffer sb = new StringBuffer();
			String str;
			while((str = br.readLine())!=null) {
				sb.append(str+"\r\n");
			}
			return sb.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String readText(String path) {
		return readText(path,"UTF-8");
	}
	
	public static List<Map<String,String>> parse(String[] keys,String str){
		List<Map<String,String>> list = new ArrayList<>();
		String[] strs = str.split("\r\n");
		for(int i=0;i<strs.length;i++) {
			String[] values = strs[i].split("\\|");
			try {
				Map<String,String> map = new HashMap<>();
				for(int idx=0;idx<keys.length;idx++) {
					map.put(keys[idx],values[idx]);
				}
				list.add(map);
			}catch(Exception e) {
				System.out.println(strs[i]);
			}
		}
		return list;
	}
	public static List<Map<String,String>> parse(String str){
		String[] strs = str.split("\\|");
		String[] keys = null;
		List<Map<String,String>> list = new ArrayList<>();
		for(int i=0;i<strs.length;i++) {
			if(i==0) {
				keys = strs[i].split(",");
			}else {
				String[] values = strs[i].split(",");
				Map<String,String> map = new HashMap<>();
				if(keys.length==values.length) {
					for(int idx=0;idx<keys.length;idx++) {
						map.put(keys[idx],values[idx]);
					}
				}
				list.add(map);
			}
		}
		return list;
	}
	/*
	 * 1. 텍스트를 읽는다.
	 * 2. 구조를 파악다(parse, load)
	 * 3. 파악된 구조를 자바에서 쉽게 사용하기 위한 구조로 변경한다.
	 * 4. 받은구조를 가지고 비지니스 로직을 수행한다.
	 */
}

