package com.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage{
	
	
	@FindBy (xpath="//div[text()=\"Sauce Labs Backpack\"]")
	private WebElement backPack;
	
	@FindBy (xpath="//div[text()=\"Sauce Labs Bike Light\"]")
	private WebElement bikeLight;
	
	public HomePage (WebDriver driver){
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickOnAddToCartBackpack() {
		backPack.click();
		
	}
	
	public void clickOnBikeLight() {
		bikeLight.click();
	}
	
	
	

}
