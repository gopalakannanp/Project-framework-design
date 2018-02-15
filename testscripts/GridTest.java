package com.hcv.testscripts;

import java.io.FileNotFoundException;


import java.io.IOException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.hcv.functionallibrary.CommonFunction;
import com.hcv.pages.HCVAccCreationPage;
import com.hcv.pages.HCVHomePage;

public class GridTest {


	@BeforeMethod
	
	@Parameters("browser")
	public void lauchApp(String browser) throws FileNotFoundException, IOException {
	CommonFunction.openBrowserGrid(browser);
	
		//CommonFunction.openBrowser();
		
	}

@AfterMethod
	public void quitApp() {
		CommonFunction.closeBrowser();
	}
@Test
public void testAdvanceFunctions_1() throws InterruptedException, IOException
{
	HCVHomePage p1 = PageFactory.initElements(CommonFunction.driver,HCVHomePage.class );
	HCVAccCreationPage p2 = PageFactory.initElements(CommonFunction.driver,HCVAccCreationPage.class);
	CommonFunction.mouseHover(p1.lnkVolunteer);
	Thread.sleep(2000);
	CommonFunction.click(p1.lnkSignUp);
	CommonFunction.waitUntilElementVisible(p2.firstname, 30);
	Thread.sleep(2000);
//get username from excel:
	String fname = CommonFunction.getdata("Sheet1", 1, 0);
	System.out.println(fname);
	Thread.sleep(2000);
	//keystorkes:
	CommonFunction.keyStrokes(p2.firstname, Keys.TAB);
	CommonFunction.keyStrokes(p2.lastname, Keys.NUMPAD4);
	CommonFunction.keyStrokes(p2.lastname, Keys.BACK_SPACE);
	Thread.sleep(2000);
	//get the parent window:
	String parent = CommonFunction.driver.getWindowHandle();
	System.out.println(parent);
	//Click on terms:
	CommonFunction.click(p2.terms);
	
	//Switch the focus:
	CommonFunction.switchWindow();
	Thread.sleep(2000);
	//Assert.assertTrue(CommonFunction.getURL().contains("Terms"));
	Assert.assertTrue(CommonFunction.getURL().contains("terms"));
	//Come back to Signup:
	CommonFunction.driver.switchTo().window(parent);
	Thread.sleep(2000);
	CommonFunction.captureScreenshot("TestAdvanceFunctions_Pass");
}

}
