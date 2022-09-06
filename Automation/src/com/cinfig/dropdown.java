package com.cinfig;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class dropdown {
	public static WebDriver driver;
	@Test
	public void selection() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		Thread.sleep(3000);
		WebElement ele = driver.findElement(By.id("course"));
	    Select crsdd = new Select(ele);
	    List<WebElement> options = crsdd.getOptions();
	    for (WebElement option : options) {
	    	System.out.println(option.getText());
	
	}
	    System.out.println(crsdd.getFirstSelectedOption().getText());
	    crsdd.selectByIndex(2);
	    Thread.sleep(2000);
	    crsdd.getAllSelectedOptions();
	    Thread.sleep(3000);
	    driver.quit();

}
}