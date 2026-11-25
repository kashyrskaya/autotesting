package com.autotesting.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.NoSuchElementException;


import java.time.Duration;

public abstract class BaseFactoryPage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    public BaseFactoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isDisplayed(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    public boolean isEnabled(WebElement element) {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
}
