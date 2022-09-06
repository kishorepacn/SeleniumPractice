package com.cinfig;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class TestUtil {
	static Properties prop = new Properties();
	static String projectpath = System.getProperty("user.dir");

	public static void main(String[] args) throws Exception, Throwable {
		getProperties();
		setProperties();
		getProperties();

	}

	public static void getProperties() {
		try {
			FileInputStream file = new FileInputStream((projectpath + "/src/com/cinfig/config1.properties"));
			prop.load(file);
			System.out.println(prop.getProperty("userName"));
			System.out.println(prop.getProperty("password"));
			System.out.println(prop.getProperty("url"));
			// System.out.println(browser);
		} catch (Exception e) { // TODO Auto-generated catch block
			e.getMessage();
			e.getCause();
			e.getStackTrace();
	}
		
	}
	public static void setProperties() {

		try {
			OutputStream output = new FileOutputStream(projectpath + "/src/com/cinfig/config1.properties");
			prop.setProperty("userName", "Admin");
			prop.setProperty("password", "admin123");
			prop.setProperty("url", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			prop.store(output, null);
			System.out.println();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
			System.out.println(e.getCause());
		}
	}
}
