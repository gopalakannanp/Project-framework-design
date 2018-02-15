package com.hcv.testscripts;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.WebDriverException;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hcv.functionallibrary.CommonFunction;

public class SmokeTest {

	@BeforeMethod
	public void lauchApp() throws FileNotFoundException, IOException,WebDriverException {
		CommonFunction.openBrowser();
	}

	@AfterMethod
	public void quitApp() {
		CommonFunction.closeBrowser();
	}
	
	@Test
	public void Ram() throws IOException {
		try {
			System.out.println("Browser launched successfuly");
			CommonFunction.captureScreenshot("Smoketest_App_Pass");
		}catch(Exception e) {
			System.out.println("Test failed: " +e);
			CommonFunction.captureScreenshot("Smoketest_App_Fail");
		}
	}
}
