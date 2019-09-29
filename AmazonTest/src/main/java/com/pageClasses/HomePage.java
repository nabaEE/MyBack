package com.pageClasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage 
{
	/***************Initialization********************/

@FindBy(xpath="//input[@id='twotabsearchtextbox']")
private static WebElement searchItem;
/***************Business Logic********************/
public static void searchItem(String item)
{
	WebElement wb=searchItem;
	wb.sendKeys(item);
	wb.sendKeys(Keys.ENTER);
	
}



}
