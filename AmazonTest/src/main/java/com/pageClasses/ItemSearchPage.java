package com.pageClasses;
import java.awt.Window;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import com.genericlibraries.BaseClass;
import com.genericlibraries.WebDriverUtils;

public class ItemSearchPage extends WebDriverUtils
{
	/***************Initialization********************/

	@FindBy(xpath="//span[text()='Redmi 5 (Rose Gold, 3GB RAM, 32GB Storage)']")
	private WebElement searchedItem;
	@FindBy(linkText="a-selected")
	private WebElement pageClick;
	
	/*********Business Methods*****************/
	
	public void scrollDownThePage()
	{	
		Actions act=new Actions(BaseClass.driver);
			act.sendKeys(Keys.PAGE_DOWN).perform();
		}
	public void clickOnTheSearchedItem()
	{
		if(searchedItem.isDisplayed())
		 {
			WebElement wb=searchedItem;
			waitForElementToPresent(BaseClass.driver, wb);
			searchedItem.click();
		 }
		else
		{
			System.out.println("Item is not available");
		}
		
	}
}