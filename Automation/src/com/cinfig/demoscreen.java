package com.cinfig;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demoscreen {
	static WebDriver driver;
	@BeforeTest
	public void Setup(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
		
		
	public void Capturescreenshot() throws Exception {
		File Scr1 =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShots/.png");
		FileUtils.copyFile(Scr1, dest);
	}
	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
