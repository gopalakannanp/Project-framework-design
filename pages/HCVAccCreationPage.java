package com.hcv.pages;

import javax.swing.JOptionPane;

//import javax.swing.JOptionPane;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hcv.functionallibrary.CommonFunction;
public class HCVAccCreationPage {
	
	
	@FindBy(xpath = "//*[@id='nav']/li[2]/a")
	public WebElement lnkVolunteer;
	@FindBy(xpath = "//*[@id='wrapper']/div[3]/div[2]/div[2]/div[1]/ul[1]/li/a[1]")
	public WebElement lnkRegister;
	@FindBy(xpath = "//*[@id='wrapper']/div[3]/div[2]/div[2]/div/form/table/tbody/tr[1]/td[2]/input")
	public WebElement firstname;
	@FindBy(xpath = "//*[@id='wrapper']/div[3]/div[2]/div[2]/div/form/table/tbody/tr[2]/td[2]/input")
	public WebElement lastname;
	@FindBy(xpath = "//*[@id='wrapper']/div[3]/div[2]/div[2]/div/form/table/tbody/tr[10]/td[2]/input")
	public WebElement emailid;
	@FindBy(xpath = "//*[@id='pass']")
	public WebElement txtpassword;
	@FindBy(xpath = "//*[@id='pass1']")
	public WebElement txtcpassword;
	@FindBy(xpath = "//*[@id='wrapper']/div[3]/div[2]/div[2]/div/form/table/tbody/tr[14]/td[2]/input[1]")
	public WebElement captcha;
	@FindBy(xpath = "//*[@id='wrapper']/div[3]/div[2]/div[2]/div/form/table/tbody/tr[15]/td/input")
	public WebElement checkbox;
	@FindBy(xpath = "//*[@id='wrapper']/div[3]/div[2]/div[2]/div/form/table/tbody/tr[18]/td[2]/input")
	public WebElement join;
	@FindBy(xpath="//*[@id='wrapper']/div[3]/div[2]/div[2]/div/form/table/tbody/tr[15]/td/a[1]")
	public WebElement terms;
	

	
	public void accCreation(String fname,String lname,String id,String pwd, String cpwd,String capt) {
		CommonFunction.click(lnkVolunteer);
		CommonFunction.click(lnkRegister);
		CommonFunction.type(firstname, fname);
		CommonFunction.type(lastname, lname);
		CommonFunction.type(emailid, id);
		CommonFunction.type(txtpassword,pwd);
		CommonFunction.type(txtcpassword,cpwd);
		capt = JOptionPane.showInputDialog("Plz enter the catcha");
		CommonFunction.type(captcha, capt);
		CommonFunction.click(checkbox);
		CommonFunction.click(join);
	}
	
}
