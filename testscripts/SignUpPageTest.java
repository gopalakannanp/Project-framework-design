package com.hcv.testscripts;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hcv.functionallibrary.CommonFunction;
import com.hcv.pages.HCVHomePage;
import com.hcv.pages.SignUpPage;

public class SignUpPageTest {
	
	@BeforeMethod
	public void lauchApp() throws Exception  {
		CommonFunction.openBrowser();
	}

	@AfterMethod
	public void quitApp() {
		CommonFunction.closeBrowser();
	}
	
	@Test
	public void testAdvanceFunction() throws Exception{
		HCVHomePage p1 = PageFactory.initElements(CommonFunction.driver, HCVHomePage.class);
		SignUpPage p2 = PageFactory.initElements(CommonFunction.driver, SignUpPage.class);
		
		CommonFunction.mouseHover(p1.lnkVolunteer);
		Thread.sleep(2000);
		CommonFunction.click(p1.lnkSignUp);
		Thread.sleep(2000);
		// get firstname from excel
		String fname = CommonFunction.getdata("Sheet1",1,0);
		CommonFunction.type(p2.txtfirstname,fname);
		
		// keystrokeds
		CommonFunction.keyStrokes(p2.txtfirstname, Keys.TAB);
		CommonFunction.keyStrokes(p2.txtlastname, Keys.NUMPAD2);
		CommonFunction.keyStrokes(p2.txtlastname, Keys.BACK_SPACE);
		Thread.sleep(2000);
		
		// get the parent window id:
		String parent = CommonFunction.driver.getWindowHandle();
		System.out.println(parent);
		
		// click on terms
		CommonFunction.click(p2.terms);
		// switch the focus: (iframe call the function --- switchToFrame
		CommonFunction.switchWindow();
		Thread.sleep(2000);
		Assert.assertTrue(CommonFunction.getURL().contains("terms"));
		
		// come back to signup page // iframe == call the function : comeOutOfOFrame
		CommonFunction.driver.switchTo().window(parent);
		CommonFunction.captureScreenshot("testAdvanceFunction_pass");
	}}
