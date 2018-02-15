package com.hcv.testscripts;

import java.io.FileNotFoundException;



import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hcv.functionallibrary.CommonFunction;
import com.hcv.pages.HCVHomePage;
import com.hcv.pages.HCVLoginErrorPage;

public class HCVHomeTest_Validation {


	@BeforeMethod
	public void lauchApp() throws FileNotFoundException, IOException {
		CommonFunction.openBrowser();
	}

	@AfterMethod
	public void quitApp() {
		CommonFunction.closeBrowser();
		
	}
	
	@Test
	public void testUnSuccessfulLogin_validation() throws IOException {
		try {
			
			HCVHomePage p1 = PageFactory.initElements(CommonFunction.driver, HCVHomePage.class);
			HCVLoginErrorPage p2 = PageFactory.initElements(CommonFunction.driver, HCVLoginErrorPage.class);
			
			p1.login("user1@gmail.com", "pass1");
			Thread.sleep(5000);
			// 4 types: AssertEquals, AssertTrue, AssertFalse, AssertFail:
			//Title validation:
Assert.assertEquals("HealthCare Volunteer - Sorry! You Must Login First", CommonFunction.gettitle(),"Login error page title is incorrect");

System.out.println(CommonFunction.gettitle());
//verify the error message
Assert.assertTrue(CommonFunction.gettext(p2.loginerror).contains("but your forgot to activate it"),"Error message is missing");
	
// no alert is displayed:
Assert.assertTrue(CommonFunction.isAlertPresent(),"Unexpected alert displayed");
			CommonFunction.captureScreenshot("testUnSuccessfulLogin_validation_Pass");
		}catch(Exception | Error e) {
			System.out.println("Test failed: " +e);
			CommonFunction.captureScreenshot("testUnSuccessfulLogin_validation_Fail");
			Assert.fail("Test failed: " +e);
		}
	}
}
