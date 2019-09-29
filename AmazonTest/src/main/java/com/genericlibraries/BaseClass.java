package com.genericlibraries;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.pageClasses.LoginPage;

public class BaseClass extends FileUtils 
{
	public static WebDriver driver;
	WebDriverUtils wdu= new WebDriverUtils();
	@BeforeClass()
	@Parameters("browser")
	public void openBrowser(String browserName)
	{
		if(browserName.equals("Chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromeserver\\chromedriver.exe");
		driver=new ChromeDriver();
		
		}
		else if(browserName.equals("FireFox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\Downloads\\geckodriver-v0.23.0-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void login() throws Exception
	{
		/*Create an Object of FileUtils class*/
	 FileUtils flib= new FileUtils();
	 Properties pObj= flib.getPropertyData();
	 wdu.waitForPageToLoad(driver);
	 driver.get(pObj.getProperty("url"));
	 LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
	 lp.moveTheCursorToSignIn();
	 lp.loginToApp(pObj.getProperty("username"), pObj.getProperty("password"));
	 }
	@AfterMethod()
	public void logout()
	{
		WebElement wb=driver.findElement(By.xpath("//a[@id='nav-link-yourAccount']/span[2]"));
		//call the actions class to move the cursor on Your orders section
		Actions act= new Actions(driver);
		 act.moveToElement(wb);
		 //click on signout
	    driver.findElement(By.xpath("//span[text()='Sign Out']")).click();
	   }
	
	@AfterClass
	public void closeBrowswer()
	{
		//close the browser
	  driver.quit();
	}
}
