package com.cinfig;

import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class PageFactoryClass {
	WebDriver driver;
	public PageFactoryClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath = "//span[.='Enter Email/Mobile number']/../../input")
	private WebElement EnterEmailoRMobileTxtField;
	
	@FindBy (xpath = "//input[@type='password']")
	private WebElement EnterPwdTxtField;
	
	@FindBy (xpath = "//button[@type='submit']//span[contains(text(),'Login')]")
	private WebElement LoginBtn;
	
	@FindBy (xpath = "//*[@title='Search for products, brands and more']")
	private WebElement SearchTxtBox;
	
	@FindBy (xpath = "//div[.='APPLE iPhone 13 (Blue, 128 GB)']")
	private WebElement Iphone13;
	
	@FindBy (xpath = "//button[@type='button']")
	private WebElement BuyNowBtn;
	
	@FindBy (xpath = "//*[.='Price details' ]/..")
	private WebElement PriceDetailsOfIphone;
	
	@FindBy (xpath = "//button[.='Deliver Here']")
	private WebElement DeliverHereBTN;
	
	@FindBy (xpath = "//button[.='CONTINUE']")
	private WebElement ContinueBTN;
	
	@FindBy (xpath = "//span[.='UPI']")
	private WebElement UPIBTN;
	
	@FindBy (xpath = "//div[.='Choose an option']")
	private WebElement ChooseOption;
	
	@FindBy (xpath = "(//div[@class='_1psGvi _3BvnxG'])[1]")
	private WebElement MyProfile;

	@FindBy (xpath = "//div[.='Logout']")
	private WebElement LogoutBTN;
	
	
	
	public void loginToFlipkart(String EmailorMobile,String password) {
		EnterEmailoRMobileTxtField.sendKeys(EmailorMobile);
		EnterPwdTxtField.sendKeys(password);
		LoginBtn.click();
		Reporter.log(MyProfile.getText(), true);
		
	}
	
	public void SelectingProduct() throws InterruptedException {
		SearchTxtBox.clear();
		Thread.sleep(1000);
		SearchTxtBox.sendKeys("iphone 13",Keys.ENTER);
		String ParentWindow = driver.getWindowHandle(); 
		Set<String> WindowHandles = driver.getWindowHandles();
		for(String Childwindow : WindowHandles) {
			if(ParentWindow != Childwindow) {
				driver.switchTo().window(Childwindow);
			}
		}
	}
	public void AddCartPage() {
		System.out.println(driver.getTitle());
		BuyNowBtn.click();	
	}
	public void CheckOutPage() {
		DeliverHereBTN.click();
		ContinueBTN.click();
		String ActualURLofthePage = driver.getCurrentUrl();
		String ExpectedURLofthePage = "https://www.flipkart.com/checkout/init?otracker=search";
		Assert.assertEquals(ActualURLofthePage, ExpectedURLofthePage,"URL of the page is matching with expectedURL");
		}
	}