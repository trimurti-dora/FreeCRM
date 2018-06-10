package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	public static long PAGE_LOAD_TIMEOUT=10;
	public static long IMPLICIT_WAIT = 15;
	public static String TESTDATA_SHEET_PATH="C:\\Users\\ASUS\\eclipse-workspace"
			+ "\\FreeCRM\\src\\main\\java\\com\\crm\\qa\\tetstdata\\TestData.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	public static void switchFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
	public static void waitTwoSecond() {
		try {
			Thread.sleep(2000);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream fis= null;
		try {
			fis= new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(fis);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sheet= book.getSheet(sheetName);
		Object data[][]= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<sheet.getLastRowNum(); i++) {
			for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
				//System.out.println(data[i][j]);
			}
		}
		return data;
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		// TODO Auto-generated method stub
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File src= screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(prop.getProperty("screenshotpath")+System.currentTimeMillis()+".png"));
	}

}
