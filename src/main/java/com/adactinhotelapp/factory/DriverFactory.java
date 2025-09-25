package com.adactinhotelapp.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.adactinhotelapp.exceptions.FrameworkException;

public class DriverFactory {
	
	public WebDriver driver;
	public Properties configProp;
	
	public WebDriver initDriver(Properties configProp)
	{
		String browserName=configProp.getProperty("browser");
		
		switch (browserName.toLowerCase()) {
		case "chrome" :
			driver=new ChromeDriver();
			
			break;

		case "firefox" :
			driver=new FirefoxDriver();
			
			break;
			
		case "edge" :
			driver=new EdgeDriver();
			
			break;
			
		default:
			
			FrameworkException fe=new FrameworkException("please pass the right browser ..choose chrome/firefox/edge");
			throw new FrameworkException("Invalid Browser Exception");
		}
		
		driver.get(configProp.getProperty("url"));
		driver.manage().window().maximize();
		
		return driver;
		
	}
	
	public Properties initProp()
	{
		FileInputStream fis=null;
		try {
			  fis=new FileInputStream("src\\test\\resources\\config\\qa.config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		configProp=new Properties();
		try {
			configProp.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return configProp;
		
	}
	

}
