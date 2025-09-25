package com.adactinhotelapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.adactinhotelapp.utils.ElementUtils;

public class SearchHotelPage extends BasePage {

	private WebDriver driver;
	private ElementUtils elementUtils;
	
	//elements or locators ==> WebElement(with PF) or By (w.o PF)
	
		//By locators 
	
	private By locationDropdown=By.xpath("//select[@name='location']");
	
	
	public SearchHotelPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		elementUtils=new ElementUtils(driver);
	}
	
	
	public void locationDropdown(String option)
	{
		elementUtils.getElement(locationDropdown).sendKeys(option);
	}
	
		

}
