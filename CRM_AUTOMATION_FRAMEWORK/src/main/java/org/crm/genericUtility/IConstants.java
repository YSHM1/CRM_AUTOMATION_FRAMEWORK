package org.crm.genericUtility;

/**
 * This interface is used for storing File Paths
 * @author ymulk
 *
 */
public interface IConstants {

	public String VTIGERPROPERTYFILEPATH = "./src/test/resources/CommonData.properties";
	public String VTIGEREXCELFILEPATH = "./src/test/resources/TestData.xlsx";
	public String LOGINFILEPATH = "./src/test/resources/UsernamePassword.xlsx";
	
	public String ABSOLUTEVTIGERPROPERTYFILEPATH = new JavaUtility().getAbsoluteFilePath("/src/test/resources/CommonData.properties");
	public String ABSOLUTEVTIGEREXCELFILEPATH = new JavaUtility().getAbsoluteFilePath("/src/test/resources/TestData.xlsx");	
}
