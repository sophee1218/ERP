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

public class PersonInputTest {

	
	public static void main(String[] args) {
		List<Map<String,String>>personList = new ArrayList<>();
		List<String> keyList = new ArrayList<>();
		File f = new File("c:\\person.txt");
		try {
			FileInputStream fis = new FileInputStream(f);
			InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String str;
			while((  str=br.readLine()  )  !=   null) {
				if(keyList.size()==0) {
					String[] keys = str.split(",");
					for(String key : keys) {
						keyList.add(key);
					}
				}else {
					Map<String,String> person = new HashMap<>();
					String[] values = str.split(",");
					
					for(int i=0;i<keyList.size();i++) {
						person.put(keyList.get(i), values[i]);
					}
					personList.add(person);
				}
			}
			System.out.println(personList);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}