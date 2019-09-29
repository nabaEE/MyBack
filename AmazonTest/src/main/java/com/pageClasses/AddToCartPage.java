package com.pageClasses;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.genericlibraries.BaseClass;

public class AddToCartPage 
{
	/***************Initialization********************/
	@FindBy(xpath="//input[@id='add-to-cart-button']")
	private WebElement addToCart;
	@FindBy(linkText="a-selected")
	private WebElement pageClick;
	@FindBy(id="nav-cart-count")
	private WebElement clickOnCart;
	@FindBy(xpath="//div[@id='sc-active-cart']/div[1]")
	private WebElement shoppingCart;
	
	/*********Business Methods*****************/
	
	public void clickOnAddToCart()
	{
		//get windows session id
		 Set<String> set= BaseClass.driver.getWindowHandles();
		 //capture the session id
		 Iterator<String> it= set.iterator();
		 String pWin=it.next();
		 String cWin=it.next();
		 //pass the driver control to childwindow
		 BaseClass.driver.switchTo().window(cWin);
		 addToCart.click();
	}
	public void clickOnCart()
	{
	 clickOnCart.click();
	}
	public String verifyResult()
	{
	  String str= shoppingCart.getText();
	   return str;
	}
	
	
}
