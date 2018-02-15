package com.hcv.testscripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hcv.functionallibrary.CommonFunction;
import com.hcv.pages.HCVHomePage;

public class HCVHomeTest {


	@BeforeMethod
	public void lauchApp() throws FileNotFoundException, IOException {
		CommonFunction.openBrowser();
	}

	@AfterMethod
	public void quitApp() {
		CommonFunction.closeBrowser();
	}
	
	@Test
	public void testUnSuccessfulLogin() throws IOException {
		try {
			
			HCVHomePage p1 = PageFactory.initElements(CommonFunction.driver, HCVHomePage.class);
			
			p1.login("user1@gmail.com", "pass1");
			Thread.sleep(5000);
			CommonFunction.captureScreenshot("testUnSuccessfulLogin_Pass");
		}catch(Exception e) {
			System.out.println("Test failed: " +e);
			CommonFunction.captureScreenshot("testUnSuccessfulLogin_Fail");
		}
	}
}

