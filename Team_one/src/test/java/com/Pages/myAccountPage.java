package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myAccountPage {
	WebDriver driver;
	
	public myAccountPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "account")
	WebElement customerInfo;
	
//	@FindBy()
	
	public void viewUserDetail() {
		customerInfo.click();
	}
}
