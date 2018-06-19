package com.kroakyhub.amazon.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoTestcase {
	
	@BeforeClass
	public void beforeClass(){
		System.out.println("This is before class");
	}
	
	@BeforeMethod
	public void beforMethod(){
		System.out.println("This is before method");
	}
	
	@Test
	public void testcase1(){
		System.out.println("This is testcase 1");
	}
	
	@Test
	public void testcase2(){
		System.out.println("This is testcase 2");
	}
	
	@AfterMethod
	public void afterMethod(){
		System.out.println("This is after method");
	}
	
	@AfterClass
	public void afterClass(){
		System.out.println("This is after class");
	}
	
	@BeforeTest
	public void beforeTest(){
		System.out.println("This is before test");
	}
	
	@AfterTest
	public void afterTest(){
		System.out.println("This is after test");
	}
	
	@BeforeSuite
	public void beforeSuite(){
		System.out.println("This is before suite");
	}
	
	@AfterSuite
	public void afterSuite(){
		System.out.println("This is after suite");
	}
	

}
