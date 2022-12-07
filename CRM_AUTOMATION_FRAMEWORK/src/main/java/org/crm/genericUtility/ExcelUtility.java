package org.crm.genericUtility;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains Excel reusable method
 * @author ymulk
 */
public final class ExcelUtility {

	private Workbook workbook;
	private FileInputStream fis;
	private FileOutputStream fos;

	/**
	 * This method is used to initialize Excel File
	 * @param filePath
	 */
	public void loadExcelFile(String filePath) {

		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getLastRowNum(String sheetName)
	{
		 Sheet sheet = workbook.getSheet(sheetName);
		 int lastRow = sheet.getLastRowNum();
		 return lastRow;
	}
	
	public int getLastCellNum(String sheetName, int rowNum)
	{
		 Sheet sheet = workbook.getSheet(sheetName);
		 int lastCell = sheet.getRow(rowNum).getLastCellNum();
		 return lastCell;
	}

	/**
	 * This method is used to fetch the data from Excel Sheet
	 * @param rowNumber
	 * @param cellNumber
	 * @param sheetName
	 * @return
	 */
	public String getExcelData(String sheetName, int rowNumber, int cellNumber) {
		Sheet sheet = workbook.getSheet(sheetName);
		String data = new DataFormatter().formatCellValue(sheet.getRow(rowNumber).getCell(cellNumber));
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	/**
	 * This method is used to write Data to Excel File
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param writeData
	 */
	public void writeDataToExcel(String sheetName, int rowNum, int cellNum, String writeData) {
		Sheet sheet = workbook.getSheet(sheetName);
		sheet.getRow(rowNum).getCell(cellNum).setCellValue(writeData);
	}
	
	/**
	 * This method is used to save Excel File
	 * @param excelFilePath
	 */
	public void saveExcelFile(String excelFilePath) {
		try {
			fos = new FileOutputStream(excelFilePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook.write(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to close Excel File(kill Excel File Object)
	 */
	public void closeExcelFile() {
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
