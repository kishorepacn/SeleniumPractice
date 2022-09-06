package com.cinfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestScreenshot extends BaseTestforFailedScreenshot {
	
	@Test(testName = "TestOrangeLogin")
	public void OrangeLogin() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Screenshot(ScreenshotSubfolderName);
	}
	
	@Test(testName = "Verifylogin")
	public void VerifyOrangeLogin() {
		SoftAssert softassert = new SoftAssert();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//selection or not
		 boolean ele = driver.findElement(By.xpath("//*[@class='oxd-main-menu-item active']")).isSelected();
		 System.out.println(ele);

		//Title Assertion
		String ActualTitle = "OrangeHRM";
		String expectedTitle = driver.getTitle();
		softassert.assertEquals(ActualTitle, expectedTitle);
		
		//URL Assertion
		String actualUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
		String expUrl = driver.getCurrentUrl();
		softassert.assertEquals(actualUrl, expUrl);
		
		driver.quit();
		softassert.assertAll();
	}

		@Test(testName ="OrangeLog2")
		public void OrangeLogin2() {
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Admin");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Screenshot(ScreenshotSubfolderName);
		}
		
}