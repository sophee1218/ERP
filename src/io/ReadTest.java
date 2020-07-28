package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadTest {

	public static void main(String[] args) {
		File f = new File("c:\\read.txt");
		try {
			FileReader fr = new FileReader(f);
			int ch = fr.read();
			String str = "";
			while(ch!=-1) {
				str+= (char)ch;
				ch = fr.read();
			}
			System.out.println(str);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
