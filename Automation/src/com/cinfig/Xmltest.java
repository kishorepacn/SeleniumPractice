package com.cinfig;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Xmltest {
	
	@Test
	public void test1() {
		Reporter.log("test t1 method execute Successfully", true);
	}
	
	@Test
	public void testt2() {
		Reporter.log("test t2 method execute Successfully", true);	
	}
	@Test
	public void testt3() {
		Reporter.log("test t3 method execute Successfully", true);
}

}