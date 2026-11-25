package com.autotesting.bdd.hooks;

import com.autotesting.core.driver.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private static WebDriver driver;

    @Before 
    public void setUp() {
        driver = WebDriverFactory.createDriver();
    }

    @After 
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    } 
}
