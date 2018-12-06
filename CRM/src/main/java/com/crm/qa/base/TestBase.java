package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase(){
		
		try {
			prop = new Properties();
			FileInputStream fis=new FileInputStream("F:\\Study\\Java_Programs\\makeMyTrip\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		    prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void initialization() {
		String browserName= prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:\\Study\\Selenium_drivers\\Drivers\\chrome\\chromedriver.exe");
			driver=new ChromeDriver();
			driver=new FirefoxDriver();
		} 
		
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "F:\\Study\\Selenium_drivers\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS); // called from TestUtil class (static variable called)
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS); // called from TestUtil class (static variable called)
		
		driver.get(prop.getProperty("url"));
	}

}
