package com.adactinhotelapp.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class Base {
	
	@BeforeClass
	public void s1()
	{
		System.out.println("In before class..");
	}
	@BeforeMethod
	public void setUp()
	{
		System.out.println("In before method");
	}

	@AfterMethod
	public void clear()
	{
		System.out.println("In after method");
	}
	@BeforeTest
	public void a1()
	{
		System.out.println("In before Test method ........................");
	}
}
