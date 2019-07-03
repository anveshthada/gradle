package com.demo.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.demo.util.Base;

public class ExtendedITestListener extends Base implements ITestListener{
	String testName, status, className;

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Started");
		testName = result.getMethod().getMethodName().trim();
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName()+" Test Case Is Passed");
		status = "PASS";
		className = result.getTestClass().getName();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName()+" Test Case Is Failed");
		status = "FAIL";
		className = result.getTestClass().getName();
		failed(result.getMethod().getMethodName().toString().trim());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		finished(testName, status, className);
	}

}