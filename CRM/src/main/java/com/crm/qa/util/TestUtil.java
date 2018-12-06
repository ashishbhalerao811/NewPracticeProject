package com.crm.qa.util;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

//import ReadExcelData.XSSFSheet;
//import ReadExcelData.XSSFWorkbook;

public class TestUtil extends TestBase{
	
	private static final WebElement WebDriver = null;
	public static long PAGE_LOAD_TIMEOUT =20;
	public static long IMPLICIT_WAIT = 10;
	public static String TESTDATA_SHEETPATH = "F:\\Study\\Java_Programs\\CRM\\src\\main\\java\\com\\crm\\qa\\testData\\FreeCrmDataDriven.xlsx";
	
	
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public void select() {
		Select selTyp=new Select(WebDriver);
		selTyp.selectByVisibleText("New");
		
	}
	
//	public static Object[][] getTestData() {
//
//		File src=new File("F:\\Study\\Java Programs\\ExcelData\\TestData.xlsx");
//		
//		FileInputStream fis=new FileInputStream(src);
//		
//		XSSFWorkbook wb=new XSSFWorkbook(fis);
//		
//		XSSFSheet sheet1=wb.getSheetAt(0); //It will get sheet no.1 from the Excel sheet.
//		
//		int rowcount=sheet1.getLastRowNum();
//		
//		System.out.println("Total rows is "+rowcount);
//		
//		for(int i=0; i<=rowcount; i++)
//		{
//			String data0=sheet1.getRow(i).getCell(0).getStringCellValue();
//			System.out.println("Test data from Excel is "+data0);
//		}
//		
//		wb.close();
//	}
		
	
}
