package com.websit.until;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class fileuiil {
	//将内容存到txt文件中
    public  String upfileuiil(String content) {
    	FileOutputStream fop = null;
    	String trueFileName = String.valueOf(System.currentTimeMillis()) + "." + "txt";
    	System.out.println(trueFileName);
    	String  ld="E:/"+trueFileName;
    	File file = new File(ld);
    	try {
			fop = new FileOutputStream(file);
			  if (!file.exists()) {
				    file.createNewFile();
				   }
			  byte[] contentInBytes = content.getBytes();
			  
			   fop.write(contentInBytes);
			   fop.flush();
			   fop.close();
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return ld;
    }
    
    //读取txt中的文件
    public static String readTxt(String filePath) {
    	 String  txt=null;
    	  try {
    	    File file = new File(filePath);
    	    if(file.isFile() && file.exists()) {
    	      InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
    	      BufferedReader br = new BufferedReader(isr);
    	      String lineTxt = null;
    	      while ((lineTxt = br.readLine()) != null) {
    	       txt=lineTxt;
    	      }
    	      br.close();
    	      
    	    } else {
    	      System.out.println("文件不存在!");
    	    }
    	  } catch (Exception e) {
    	    System.out.println("文件读取错误!");
    	  }
    	  return txt;
    }
    public static void main(String[] args) {
        String filePath = "F:/1553134223693.txt";
        System.out.println(readTxt(filePath));
      }
}
