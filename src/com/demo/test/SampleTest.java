package com.demo.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demo.listeners.ExtendedITestListener;
import com.demo.util.Base;

public class SampleTest extends Base {
	
	@BeforeMethod
	public void beforeMethod() {
		initialization();
	}
	
	@AfterMethod
	public void afterMethod() {
		finished(ExtendedITestListener.testName, ExtendedITestListener.status, ExtendedITestListener.className);
		driver.quit();
	}
	
	@Test
	public void basicTest() {
		Assert.assertTrue(false);
	}
}