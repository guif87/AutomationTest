package com.aequilibrium.support;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestUtils {

    private static WebDriver driver;
    private static String CHROME_DRIVER_LINUX = "/usr/bin/chromedriver";
    private static String CHROME_DRIVER_WINDOWS = "src/main/resources/chromedriver.exe";
    private static String DEFAULT_URL = "https://www.saucedemo.com";

    @Before
    public void beforeScenario() {
        final boolean isLinux = Files.exists(Paths.get(CHROME_DRIVER_LINUX));
        final String chromeBinary = isLinux ? CHROME_DRIVER_LINUX : CHROME_DRIVER_WINDOWS;
        System.setProperty("webdriver.chrome.driver", chromeBinary);
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to(DEFAULT_URL);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @After
    public void afterScenario() {
        if (driver != null) {
            driver.quit();
        }
    }
}