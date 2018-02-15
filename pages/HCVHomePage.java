package com.hcv.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import com.hcv.functionallibrary.CommonFunction;

public class HCVHomePage {

	@FindBy(xpath = "//*[@id='main']/div[1]/div[2]/div[1]/ul/form/li[2]/input")
	public WebElement txtusername;
	@FindBy(xpath = "//*[@id='main']/div[1]/div[2]/div[1]/ul/form/li[3]/input")
	public WebElement txtpassword;
	@FindBy(xpath = "//*[@id='main']/div[1]/div[2]/div[1]/ul/form/li[4]/button")
	public WebElement btnlogin;
	@FindBy(xpath = "//*[@id='nav']/li[2]/a")
	public WebElement lnkVolunteer;
	@FindBy(xpath = "//*[@id='nav']/li[2]/ul/li[1]/a")
	public WebElement lnkSignUp;
	
	
	public void login(String usr, String pwd) {
		
		CommonFunction.type(txtusername, usr);
		CommonFunction.type(txtpassword, pwd);
		CommonFunction.click(btnlogin);
		
	}
	
}
