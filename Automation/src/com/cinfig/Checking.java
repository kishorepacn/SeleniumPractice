package com.cinfig;

import org.testng.annotations.Test;

public class Checking {
	static String trackinno = null;
	
	@Test(groups = {"smoke"})
	public void test1() {
		System.out.println("test 1 passed");
	}

	@Test(groups= {"functional","regression"})
	public void test2() {
		System.out.println("test 2 passed");
	}
	@Test
	public void test3() {
		System.out.println(5/0);
		System.out.println("test 3 passed");
		trackinno = "123";
	}
	@Test(dependsOnMethods = {"test3"})
	public void test4() throws Exception {
		if(trackinno != null) {
		System.out.println("test 4 passed");
		}else {
			throw new Exception("invalid tracking nomber");

}
		
}
}


