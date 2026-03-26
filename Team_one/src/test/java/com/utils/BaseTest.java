package com.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    protected WebDriver     driver;
    protected WebDriverWait wait;
    protected Properties    config;

    // ── Base URL (edit here if needed) ────────────────────────────────────────
    protected static final String SITE_URL      = "https://demowebshop.tricentis.com/";
    protected static final String USER_EMAIL    = "testngteam1@gmail.com";
    protected static final String USER_PASSWORD = "12345@test";  // ← change this!
    @BeforeClass
    public void setUp() throws IOException {
        config = loadConfig();

        String browser = config.getProperty("browser", "chrome").toLowerCase();

        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                // options.addArguments("--headless");  // uncomment for headless
                options.addArguments("--start-maximized");
                options.addArguments("--disable-notifications");
                options.addArguments("--disable-popup-blocking");
                driver = new ChromeDriver(options);
                break;
        }

        int implicitWait = Integer.parseInt(config.getProperty("implicit.wait", "10"));
        int explicitWait = Integer.parseInt(config.getProperty("explicit.wait", "15"));
        int pageLoad     = Integer.parseInt(config.getProperty("page.load.timeout", "30"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoad));
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait));

       
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Loads config.properties from the classpath (src/test/resources/).
     * This works correctly whether run from Eclipse, IntelliJ, or Maven CLI.
     */
    private Properties loadConfig() throws IOException {
        Properties props = new Properties();

        // getResourceAsStream reads from the classpath — no path issues
        try (InputStream is = getClass()
                .getClassLoader()
                .getResourceAsStream("config.properties")) {

            if (is == null) {
                throw new IOException(
                    "config.properties not found in src/test/resources/. " +
                    "Make sure the file exists and the folder is marked as a Test Resources root."
                );
            }
            props.load(is);
        }
        return props;
    }
}
