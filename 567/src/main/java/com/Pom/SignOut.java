package com.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignOut {
	
	@FindBy (id="react-burger-menu-btn")
	private WebElement menuBar;
	
	@FindBy(xpath="//a[@id=\"logout_sidebar_link\"]")
	private WebElement logOut;
	
	public SignOut(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMenu() {
		menuBar.click();
		
	}
	
	public void clickOnLogout() {
		logOut.click();
	}

}
