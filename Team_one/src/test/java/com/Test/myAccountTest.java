package com.Test;

import com.Pages.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class myAccountTest {

    WebDriver driver;
    myAccountPage myAccountPage;

    @BeforeClass
    public void setup() {
        // Launch browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        // Open application (change URL if needed)
        driver.get("https://demowebshop.tricentis.com/");

        // Initialize Page Object
        myAccountPage = new myAccountPage(driver);
    }

    @Test
    public void testViewUserDetails() {
        // Click on account section
        myAccountPage.viewUserDetail();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}