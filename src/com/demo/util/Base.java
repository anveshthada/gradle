package com.demo.util;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	public static WebDriver driver;
	
	public void initialization() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
	}
	
	public void failed(String testCaseName) {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			System.out.println(System.getProperty("user.dir")+"/target/screenshots/"+testCaseName+".png");
			FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\target\\screenshots\\"+testCaseName+".png"));
		}catch (Exception e) {
			e.printStackTrace(); 
		}
	}

}
