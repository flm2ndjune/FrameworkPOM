package com.adactinhotelapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.adactinhotelapp.utils.ElementUtils;

public class LoginPage extends BasePage{

	private WebDriver driver;
	private ElementUtils elementUtils;
	//elements or locators ==> WebElement(with PF) or By (w.o PF)
	
	//By locators 
	private final By usernameTextbox=By.xpath("//input[@name='username']");
	private final By passwordTextbox=By.xpath("//input[@name='password']");
	private final By loginButton=By.xpath("//input[@name='login']");
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		elementUtils=new ElementUtils(driver);
	}
	
	//methods 
	
	public void usernameTextbox(String text)
	{
		elementUtils.getElement(usernameTextbox).sendKeys(text);
	}

	public void passwordTextbox(String text)
	{
		elementUtils.getElement(passwordTextbox).sendKeys(text);
	}
	
	public void loginButton()
	{
		elementUtils.getElement(loginButton).click();
	}
	
	public void doLogin()
	{
		usernameTextbox(prop.getProperty("username"));
		passwordTextbox(prop.getProperty("password"));
		loginButton();
	}
	
}
