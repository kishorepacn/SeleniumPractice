package com.cinfig;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Parameters {

	protected static WebDriver driver;
	//Constructor
	/*
	 * public void Parameters(WebDriver driver) { this.driver=driver;
	 * PageFactory.initElements(driver,this); }
	 */
	
	/*
	 * @FindBy(id ="hbsf") private WebElement kishore;
	 */
		
		
	
		@BeforeTest
		public static void InitialiseBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
		@AfterTest
		public void teardownBrowser() {
			driver.quit();
		}
	}
