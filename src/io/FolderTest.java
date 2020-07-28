package io;

import java.io.File;

public class FolderTest {

   
   public static void main(String[] args) {
      
   
      AddressTest at = new AddressTest();
      

         File path = new File("C:\\Users\\m2lod\\OneDrive\\바탕 화면\\202006_건물DB_전체분");
         if(path.isDirectory()) {

            File[] files = path.listFiles();
            
            for(File file : files) {
               
               if(!file.isDirectory() && file.getName().indexOf("build_")==0)
            
                  System.out.println("시작");
                    at.exePath(file.toString());
                     System.out.println("끝");
            }
      
   }
         
        System.out.println("다 끝!");
   }
   
}

