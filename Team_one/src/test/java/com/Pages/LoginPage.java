package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page Object for: https://demowebshop.tricentis.com/login
 *
 * LOCATORS REFERENCE:
 * ─────────────────────────────────────────────────────────────────────────────
 *  Element                    │ Locator Type │ Value
 * ─────────────────────────────────────────────────────────────────────────────
 *  Email field                │ ID           │ Email
 *  Password field             │ ID           │ Password
 *  Login button               │ CSS          │ input.login-button
 *  Logout link                │ CSS          │ a.ico-logout
 *  Account link (email shown) │ CSS          │ a.account
 *  Login error message        │ CSS          │ div.validation-summary-errors span
 *  Email validation error     │ CSS          │ span[data-valmsg-for='Email']
 *  Password validation error  │ CSS          │ span[data-valmsg-for='Password']
 * ─────────────────────────────────────────────────────────────────────────────
 */
public class LoginPage {

    private final WebDriver     driver;
    private final WebDriverWait wait;

    // ── Locators ──────────────────────────────────────────────────────────────

    /** Email input field — ID: Email */
    @FindBy(id = "Email")
    private WebElement emailField;

    /** Password input field — ID: Password */
    @FindBy(id = "Password")
    private WebElement passwordField;

    /** Login submit button — CSS: input.login-button */
    @FindBy(css = "input.login-button")
    private WebElement loginButton;

    /** Logout link (visible only when logged in) — CSS: a.ico-logout */
    @FindBy(css = "a.ico-logout")
    private WebElement logoutLink;

    /** Account link showing logged-in user's email — CSS: a.account */
    @FindBy(css = "a.account")
    private WebElement accountLink;

    /** Login error summary message — CSS: div.validation-summary-errors span */
    @FindBy(css = "div.validation-summary-errors span")
    private WebElement loginErrorMessage;

    /** Inline validation error for email — CSS: span[data-valmsg-for='Email'] */
    @FindBy(css = "span[data-valmsg-for='Email']")
    private WebElement emailValidationError;

    /** Inline validation error for password — CSS: span[data-valmsg-for='Password'] */
    @FindBy(css = "span[data-valmsg-for='Password']")
    private WebElement passwordValidationError;

    // ── Constructor ───────────────────────────────────────────────────────────

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait   = wait;
        PageFactory.initElements(driver, this);
    }

    // ── Navigation ────────────────────────────────────────────────────────────

    /** Navigate directly to the login page. */
    public void navigateToLoginPage() {
        driver.get("https://demowebshop.tricentis.com/login");
    }

    // ── Actions ───────────────────────────────────────────────────────────────

    /** Type into the Email field. */
    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.clear();
        emailField.sendKeys(email);
    }

    /** Type into the Password field. */
    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    /** Click the Login button. */
    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    /**
     * Convenience: fill email + password then click Login.
     */
    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    /** Click the Logout link. */
    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
    }

    // ── State / Assertions ────────────────────────────────────────────────────

    /** Returns true if the logout link is visible (user is logged in). */
    public boolean isLoggedIn() {
        try {
            return logoutLink.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /** Returns the email text shown in the account link after login. */
    public String getLoggedInUserEmail() {
        return wait.until(ExpectedConditions.visibilityOf(accountLink)).getText();
    }

    /** Returns the login error message text. */
    public String getLoginErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOf(loginErrorMessage)).getText();
    }

    /** Returns true if the email inline validation error is visible. */
    public boolean isEmailValidationErrorDisplayed() {
        try {
            return emailValidationError.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /** Returns true if the password inline validation error is visible. */
    public boolean isPasswordValidationErrorDisplayed() {
        try {
            return passwordValidationError.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /** Returns the current browser URL. */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
