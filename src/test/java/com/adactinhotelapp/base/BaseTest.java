package com.adactinhotelapp.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.adactinhotelapp.factory.DriverFactory;

public class BaseTest {
	
	protected WebDriver driver;
	DriverFactory diverFactory;
	Properties prop;
	
	
	@BeforeTest
	public void setUp()
	{
		diverFactory=new DriverFactory();
		prop=diverFactory.initProp();
		
		
		
		
	}
	
	@BeforeMethod
	public void appLaunch()
	{
		driver=diverFactory.initDriver(prop);
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
	}
	
	@AfterTest
	public void teardown()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//driver.quit();
	}
	

}
