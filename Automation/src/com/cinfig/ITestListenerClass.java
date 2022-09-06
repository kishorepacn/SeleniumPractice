package com.cinfig;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerClass extends BaseTestforFailedScreenshot implements ITestListener {
	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getTestContext().getName()+ "_"+result.getMethod().getMethodName());
		Screenshot(result.getTestContext().getName()+ "_"+result.getMethod().getMethodName()+".png");
	}
	
	

}
