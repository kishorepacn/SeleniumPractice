package com.cinfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.ITestListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicExecution implements ITestListener{
	WebDriver driver;
	
	@Parameters("browserName")
	@BeforeTest
	public void Initialise(String browserName) {
		
		switch(browserName.toLowerCase()){
		case "chrome":
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		break;
		case "opera":
		WebDriverManager.operadriver().setup();
		driver = new OperaDriver();
		break;
		default:
			System.err.println("browserName is invalid");
		
		}
		
	}
	@Parameters("url")
	@Test
	public void url(String url) {
		driver.get(url);
	}
	@AfterTest
	public void teardown() {
		driver.quit();
	}
}