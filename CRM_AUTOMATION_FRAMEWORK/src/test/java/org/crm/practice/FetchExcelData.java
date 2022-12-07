package org.crm.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchExcelData {
	public static void main(String[] args) throws IOException {
		DataFormatter dataFormat = new DataFormatter();
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		for (int i=0;i<=sheet.getLastRowNum();i++) {
			String data = dataFormat.formatCellValue(sheet.getRow(i).getCell(1));
			//System.out.println(data);
			if (data.equalsIgnoreCase("organizationname")) {
				System.out.println(data); 
				break;
			}
		}
		wb.close();
	}
}
