package com.Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Base.Base;
import com.Pom.HomePage;
import com.Pom.LoginPage;
import com.Pom.SignOut;
import com.Utility.Utility;


public class TestClass extends Base {
	
	WebDriver driver;
	LoginPage pageLogin;
	HomePage homePage;
	
	@BeforeTest
	@Parameters("browser")
	public  void launchBrowser(String browser) throws InterruptedException {
		
		if(browser.equals("chrome")) {
		
			driver = Base.openChrome();
		}
		else if(browser.equals("edge")) {
			driver=Base.openEdge(); \
		}
		
		
		driver.get("https://www.saucedemo.com"); 
		driver.manage().window().maximize();
		Thread.sleep(2000);
			
	}
	
	@BeforeMethod
	public void verifyLoginPage() throws InterruptedException, EncryptedDocumentException, IOException {
		System.out.println("After value ::"+driver);
		
		pageLogin = new LoginPage(driver);
		String username1 = Utility.getExcelData(1, 0);
		
		pageLogin.clickOnUsername(username1);
		
		String pass = Utility.getExcelData(1, 1);
		pageLogin.clickOnPass(pass);
		pageLogin.clickOnLogin();
		Thread.sleep(2000);
	}
	
	@Test 
	public void verifyBagPack() {
		homePage = new HomePage(driver);
		homePage.clickOnAddToCartBackpack();
	}
	
	@Test 
	public void verifyBikeLight() {
		homePage.clickOnBikeLight();
		
	}
	
	@AfterMethod
	public void verifyLogOut(ITestResult result) throws InterruptedException, IOException  {
		
			
		SignOut signOut = new SignOut(driver);
			
		signOut.clickOnMenu();
		Thread.sleep(1000);
		signOut.clickOnLogout();
		Thread.sleep(2000);
		
		if (ITestResult.SUCCESS==result.getStatus()){
			Utility.getScreenShot(driver);
			
		}
		
		
	}
	
	@AfterTest
	public void closeBrowers() {
		driver.close();
	}

}
