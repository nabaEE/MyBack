package com.pageClasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.genericlibraries.BaseClass;

public class LoginPage
{

	/***************Initialization********************/
	@FindBy(xpath="//span[text()='Hello, Sign in']")
	private static WebElement clickToSignIn;
	@FindBy(name="email")
	private static WebElement userNameEdt;
	@FindBy(id="continue")
	private static WebElement continueBtn;
	@FindBy(name="password")
	private static WebElement passwordEdt;
	@FindBy(id="signInSubmit")
	private static WebElement loginBtn;
	
	   /*********Business Methods*****************/
   
 public static void moveTheCursorToSignIn()
 {
	 clickToSignIn.click();
	
 }
 
 public static void loginToApp(String username, String password1)
 {
	 userNameEdt.sendKeys(username);
	 continueBtn.click();
	WebElement wb=passwordEdt;
	wb.sendKeys(password1);
	loginBtn.click();
	 
	 
 }

}
