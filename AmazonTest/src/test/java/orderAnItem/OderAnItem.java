package orderAnItem;
/**
 * @author Nabaghana
 * 
 */
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.genericlibraries.BaseClass;
import com.genericlibraries.FileUtils;
import com.pageClasses.AddToCartPage;
import com.pageClasses.HomePage;
import com.pageClasses.ItemSearchPage;
public class OderAnItem extends BaseClass
{
 @Test
 public void verifyAnItem() throws FileNotFoundException
 {
	String expResult="Shopping Cart1";
     FileUtils flib1= new FileUtils();
	 Properties pObj=flib1.getPropertyData();
	 
	 //call the homepage to search for Redmi note
	 HomePage hp= PageFactory.initElements(driver, HomePage.class);
	 hp.searchItem(pObj.getProperty("item"));
	 //call the itemSearchPage to verify the selected item is present or not
	 ItemSearchPage isp= PageFactory.initElements(driver, ItemSearchPage.class);
	 isp.scrollDownThePage();
	 isp.clickOnTheSearchedItem();
	 //call the addToCart page to select the item to cart
	 AddToCartPage atp= PageFactory.initElements(driver, AddToCartPage.class);
	 atp.clickOnAddToCart();
	 atp.clickOnCart();
	 String actResult=atp.verifyResult();
	Assert.assertEquals(actResult, expResult);
	Reporter.log("Test case passed", true);
	/*if(actResult.equalsIgnoreCase(expResult))
	{
		System.out.println("The test case passed");
	}
	else
	{
		System.out.println("Test case got failed");
	}
	 */
	
}
}

