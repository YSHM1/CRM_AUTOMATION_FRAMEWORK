package org.crm.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This Class contains Property File reusable methods
 * @author ymulk
 */
public final class FileUtility {
	
	private FileInputStream fis;
	private Properties property;
	
	/**
	 * This method is used to initialize Property File 
	 * @param filePath
	 */
	public void loadPropertyFile(String filePath) {
		try {
			fis=new FileInputStream(filePath);
			property=new Properties();
			property.load(fis);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is used to read data from Property File
	 * @param key
	 * @return
	 */
	public String getPropertyFileData(String key) {
		String data =property.getProperty(key);
		return data;
	}
	
}
