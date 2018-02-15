package com.hcv.pages;

import javax.swing.JOptionPane;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.hcv.functionallibrary.CommonFunction;


public class SignUpPage {
	
	@FindBy (xpath ="//*[@id='wrapper']/div[3]/div[2]/div[2]/div/form/table/tbody/tr[1]/td[2]/input")
	public WebElement txtfirstname;
	@FindBy (xpath ="//*[@id='wrapper']/div[3]/div[2]/div[2]/div/form/table/tbody/tr[2]/td[2]/input")
	public WebElement txtlastname;
	@FindBy (xpath ="//*[@id='wrapper']/div[3]/div[2]/div[2]/div/form/table/tbody/tr[10]/td[2]/input")
	public WebElement txtemail;
	@FindBy (xpath ="//*[@id='pass']")
	public WebElement txtpassword;
	@FindBy (xpath ="//*[@id='pass1']")
	public WebElement txtpassword2;
	@FindBy (xpath ="//*[@id='wrapper']/div[3]/div[2]/div[2]/div/form/table/tbody/tr[14]/td[2]/input[1]")
	public WebElement txtcaptcha;
	@FindBy (xpath ="//*[@id='wrapper']/div[3]/div[2]/div[2]/div/form/table/tbody/tr[15]/td/input")
	public WebElement checkbox;
	@FindBy (xpath ="//*[@id='wrapper']/div[3]/div[2]/div[2]/div/form/table/tbody/tr[18]/td[2]/input")
	public WebElement btnjoin;
	@FindBy (xpath ="//*[@id='wrapper']/div[3]/div[2]/div[2]/div/span[1]")
	public WebElement pageHeading;
	@FindBy (xpath ="//*[@id='wrapper']/div[3]/div[2]/div[2]/div/form/table/tbody/tr[15]/td/a[1]")
	public WebElement terms;
	
	
	public void signUp(){
		CommonFunction.type(txtfirstname, "test");
		CommonFunction.type(txtlastname, "test");
		CommonFunction.type(txtemail, "test9875@gmail.com");
		CommonFunction.type(txtpassword, "test1");
		CommonFunction.type(txtpassword2, "test1");
		String text = JOptionPane.showInputDialog("Please enter ");
		CommonFunction.type(txtcaptcha, text);
		if(checkbox.isSelected())
			System.out.println("Already checked");
		else
			CommonFunction.click(checkbox);
		CommonFunction.click(btnjoin);
	}
}

