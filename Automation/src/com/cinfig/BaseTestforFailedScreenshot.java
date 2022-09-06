package com.cinfig;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestforFailedScreenshot {
	static WebDriver driver;
	static String ScreenshotSubfolderName;
	
	@BeforeTest
	public void setup(){
	 WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
		
	}
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	public void Screenshot(String fileName) {
		if(ScreenshotSubfolderName==null) {
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-YYYY HH:MM:SS");
		ScreenshotSubfolderName = myDateObj.format(myFormatObj);
	}
		TakesScreenshot TakeShot = (TakesScreenshot)driver;
		File src =TakeShot.getScreenshotAs(OutputType.FILE);
		File dest =new File("./ScreenPiccture/"+ScreenshotSubfolderName+"/"+fileName);
		try {
			FileUtils.copyDirectory(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getCause();
			e.getMessage();
		}
		
	}

}
