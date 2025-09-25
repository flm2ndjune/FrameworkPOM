package com.adactinhotelapp.utils;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	
	private WebDriver driver;
	
	public ElementUtils(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getElement(By by) {
		
		WebElement element=null;
		
		element=driver.findElement(by);
		
		if(isElementDisplayed(element))
		{
			return element;
		}
		else
		{
		return element;
		}
		
		
		
	}

	public boolean isElementDisplayed(WebElement element) {
		
		try
		{
			return element.isDisplayed();
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Element is not displayed on the page ");
			return false;
		}
		
		
		
	}	

}
