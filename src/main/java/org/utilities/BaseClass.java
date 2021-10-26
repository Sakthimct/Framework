package org.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
	public static void launchChrome() {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
	}

	public static void loadUrl(String url) {
		
		driver.get(url);

	}
	
	public static void winMax() {
		driver.manage().window().maximize();
	}
	
	public static void printTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}
	
	public static void printCurrentUrl() {

		String current = driver.getCurrentUrl();
		
		System.out.println(current);
		
	}
	
	public static void Fill(WebElement ele, String value) {
		
		ele.sendKeys(value);

	}
	
	public static void clk(WebElement ele) {
		
		ele.click();
				
	}
	
	public static void printText(WebElement ele) {
		
		String text = ele.getText();
		
		System.out.println(text);
		
	}
	
	public static void closeBrowser() {
		driver.close();
	}
	
	
	public static String getdata(int rowNumber,int cellNumber ) throws IOException {
		
		File f = new File("C:\\Users\\Lenovo\\Desktop\\New folder\\FrameWork\\TestData\\Student Details - Copy.xls");
		
		FileInputStream fi = new FileInputStream(f);
		
		Workbook w = new HSSFWorkbook(fi);
		
		Sheet s = w.getSheet("Students");
		
		Row row = s.getRow(rowNumber);
		
		Cell cell = row.getCell(cellNumber);
		
		int cellType = cell.getCellType();
		
		String value = "";
		
		if (cellType==1) {
			
			value = cell.getStringCellValue();
		}
		
		else if (cellType==0) {
			
			if (DateUtil.isCellDateFormatted(cell)) {
				
				Date d = cell.getDateCellValue();
				
				SimpleDateFormat sim = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");
				
				value = sim.format(d);
				
			}else {
				double d = cell.getNumericCellValue();
				
				long l = (long)d;
				
				value = String.valueOf(l);
			}
			
		}
		
		return value;
		
		
		

	}
	
	
	
	
	

}
