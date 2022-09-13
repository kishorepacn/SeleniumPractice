package com.cinfig;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.*;

public class BaseTestForFlipkart {

	 protected static WebDriver driver=null;

	    @BeforeTest
	    public void setUp(){
	    	WebDriverManager.chromedriver().setup();
	        driver= new ChromeDriver();
	        driver.get("https://www.flipkart.com/");
	        Reporter.log(driver.getCurrentUrl(),true);
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        
	    }

	    @AfterTest
	    public void teardown(){
	    driver.quit();
	    }
	}


