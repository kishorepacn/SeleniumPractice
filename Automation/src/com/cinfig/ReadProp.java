package com.cinfig;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import graphql.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadProp {
	protected static WebDriver driver;
	protected static Properties prop = new Properties();	
	
	public static void getProperty() throws Exception {
		String projectpath = System.getProperty("user.dir");
		FileInputStream ipfile = new FileInputStream(projectpath+"/src/com/cinfig/read.properties");
		prop.load(ipfile);
		System.out.println(prop.getProperty("browser"));
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("Opera")) {
			WebDriverManager.operadriver().setup();
				driver = new OperaDriver();
		}else {
					System.out.println("no browser value is given");
		}
		System.out.println("hi");
	}
		
	public static void loginTest() throws Exception {
			driver.get(prop.getProperty("url"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.name("username")).sendKeys(prop.getProperty("username"));
			driver.findElement(By.name("password")).sendKeys("password");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			boolean flag = driver.findElement(By.xpath("//P[.='Invalid credentials']")).isDisplayed();
			Assert.assertTrue(flag);
			Reporter.log(flag+ "error message is displaying",true);
			//boolean flag =driver.findElement(By.xpath("//img[@alt='profile picture']")).isDisplayed();
			//Assert.assertTrue(flag);
			driver.quit();
}
}