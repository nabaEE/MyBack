package com.genericlibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtils 
{

	String path="./TestData/commonData.property.txt";
	public Properties getPropertyData() throws FileNotFoundException
	 {
		 FileInputStream fis= new FileInputStream(path);
		 Properties pObj= new Properties();
		 try {
		pObj.load(fis);
	  
	      } 
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pObj;
 
	

      }
}
