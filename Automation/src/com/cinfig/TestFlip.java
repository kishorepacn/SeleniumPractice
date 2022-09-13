package com.cinfig;

import org.testng.annotations.*;

public class TestFlip extends BaseTestForFlipkart {
	
	@Test
	public void Test() throws InterruptedException {
		PageFactoryClass pg = new PageFactoryClass(driver);
		pg.loginToFlipkart("8374461013", "8374461013kk");
		pg.SelectingProduct();
		pg.AddCartPage();
		pg.CheckOutPage();
		
	}
}
