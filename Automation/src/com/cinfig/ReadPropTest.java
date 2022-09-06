package com.cinfig;

import org.testng.annotations.Test;

public class ReadPropTest {
	
	@Test
	public void readdataprop() throws Exception {
	ReadProp readdata = new ReadProp();
	readdata.getProperty();
	readdata.loginTest();

}
}
