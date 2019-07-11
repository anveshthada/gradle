package com.demo.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void failed(String testCaseName) {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\target\\screenshots\\"+testCaseName+".png"));
		}catch (Exception e) {
			e.printStackTrace(); 
		}
	}
	
	protected void finished(String actualTestMethod,String status,String actualTestClass) {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("target/teststream.txt", true)));
            out.println("{\"metodo\":\""+actualTestMethod+"\", \"status\":\""+status+"\", "
       + "\"classe\":\""+actualTestClass+"\", \"descricao\":\""+actualTestMethod+"\"}");
            out.close();
        } catch (IOException e) {
         e.printStackTrace();
        }
    } 

}
