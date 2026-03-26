package com.Test;

import com.Pages.LoginPage;
import com.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeMethod
    public void initPage() {
        loginPage = new LoginPage(driver, wait);
        loginPage.navigateToLoginPage();
    }

    @Test(priority = 1, description = "TC-01: Verify successful login with valid credentials")
    public void testValidLogin() {
        loginPage.login(config.getProperty("user.email"), config.getProperty("user.password"));
        Assert.assertTrue(loginPage.isLoggedIn(), "User should be logged in after valid credentials");
        Assert.assertEquals(loginPage.getLoggedInUserEmail(), config.getProperty("user.email"),
                "Logged-in email should match");
    }

    @Test(priority = 2, description = "TC-02: Verify error message with invalid password")
    public void testInvalidPassword() {
        loginPage.login(config.getProperty("user.email"), "wrongPassword123");
        String error = loginPage.getLoginErrorMessage();
        Assert.assertFalse(error.isEmpty(), "Error message should be displayed for invalid credentials");
    }

    @Test(priority = 3, description = "TC-03: Verify validation error when email is empty")
    public void testEmptyEmail() {
        loginPage.enterEmail("");
        loginPage.enterPassword("anyPassword");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isEmailValidationErrorDisplayed(),
                "Validation error should appear for empty email");
    }

    @Test(priority = 4, description = "TC-04: Verify validation error when password is empty")
    public void testEmptyPassword() {
        loginPage.enterEmail(config.getProperty("user.email"));
        loginPage.enterPassword("");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isPasswordValidationErrorDisplayed(),
                "Validation error should appear for empty password");
    }

    @Test(priority = 5, description = "TC-05: Verify successful logout")
    public void testLogout() {
        loginPage.login(config.getProperty("user.email"), config.getProperty("user.password"));
        Assert.assertTrue(loginPage.isLoggedIn(), "Pre-condition: user must be logged in");
        loginPage.logout();
        Assert.assertFalse(loginPage.isLoggedIn(), "User should not be logged in after logout");
    }
}
