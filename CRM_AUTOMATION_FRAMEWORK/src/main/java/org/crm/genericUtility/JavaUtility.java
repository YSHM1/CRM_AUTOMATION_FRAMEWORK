package org.crm.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class contains all the Java reusable methods
 * @author ymulk
 *
 */
public class JavaUtility {

	/**
	 * This method is use to generate Random Number within limit
	 * @param limit
	 * @return integer value
	 */
	public int getRandomNumber(int limit) {
		return new Random().nextInt(limit);
	}

	/**
	 * This method is used to generate Random Number within 1000
	 * @return
	 */
	public int getRandomNumber() {
		return new Random().nextInt(1000);
	}

	/**
	 * This method is used to convert Numeric values in String Format to long type 
	 * @param stringValue
	 * @return
	 */
	public long convertStringToLong(String stringValue) {
		return Long.parseLong(stringValue);
	}
	
	/**
	 * This method is used to convert Numeric values in String Format to int type
	 * @param stringValue
	 * @return
	 */
	public int convertStringToInteger(String stringValue) {
		return Integer.parseInt(stringValue);
	}
	
	/**
	 * This method is used to remove specific characters from String
	 * @param data
	 * @param strategy
	 * @param index
	 * @return
	 */
	
	public String getSplitStringValue(String data, String removeCharacter, int index) {
		String[] splitString = data.split(removeCharacter);
		for (String string : splitString) {
			System.out.println(string);
		}
		int arrayLength = splitString.length;
		if (index >= 0 && index < arrayLength) {
			return splitString[index];
		} else
			return "Entered Index is greater than or equal to Array Length";
	}

	/**
	 * This method is used to get Date in Simple Format
	 * 
	 * @param dateFormat In dateFormat variable pass date format ---> dd/MM/yyyy or
	 * dd/MMM/yyyy or dd/MMMM/yyyy in String type
	 * @return
	 */
	public String getSimpleCurrentDate(String dateFormat) {
		return new SimpleDateFormat(dateFormat).format(new Date());
	}

	/**
	 * This method is used to get a name of class
	 * 
	 * @return
	 */
	public String getSimpleFormatClassName(Object currentClass) {
		return currentClass.getClass().getSimpleName();
	}
	
	/**
	 * This method is used to get Absolute Path(Compelete Path) of Files
	 * @param filePath
	 * @return
	 */
	public String getAbsoluteFilePath(String filePath) {
		return System.getProperty("user.dir") + filePath;
	}
	
//	public String replaceFromString(String data,String remove) {
//		return String.format(data, remove);
//	}
}
