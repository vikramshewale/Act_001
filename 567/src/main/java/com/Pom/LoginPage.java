package com.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy (id="user-name")
	private WebElement userName;
	
	@FindBy (id="password")
	private WebElement passWord;
	
	@FindBy (id="login-button")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnUsername(String username) {
		userName.sendKeys(username);
	}
	
	public void clickOnPass(String password) {
		passWord.sendKeys(password);
	}
	
	public void clickOnLogin() {
		loginButton.click();
	}

		
	
	

	
}
