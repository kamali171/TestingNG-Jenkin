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
	
	@FindBy(xpath = "//input[@id='Email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='Password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@value='Log in']")
	WebElement logInBtn;
	
	@FindBy(xpath = "(//h1[normalize-space()='My account - Customer info'])[1]")
	WebElement cem;
	
	public void viewUserDetail() {
		customerInfo.click();
	}
	
	public void enterDetails() {
		String exp = "My account - Customer info";
		email.sendKeys("exampleam@gmail.com");
		password.sendKeys("asdfghjkl");
		logInBtn.click();
		String act = cem.getText();
		if(act.equals(exp)) {
			System.out.println("Logged In Successfully");
		}
		else {
			System.out.println("Log In is not successful");
		}
	}
}
