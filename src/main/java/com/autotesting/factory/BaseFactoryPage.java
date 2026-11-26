package com.autotesting.factory;

import org.openqa.selenium.JavascriptExecutor;
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
    protected final JavascriptExecutor js;

    public BaseFactoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;
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

    public boolean waitForUrl(String expectedUrl) {
        try {
            return wait.until(ExpectedConditions.urlToBe(expectedUrl));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean waitForUrlContains(String expectedUrlFragment) {
        try {
            return wait.until(ExpectedConditions.urlContains(expectedUrlFragment));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void scrollBy(int x, int y) {
        js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
    }

    /**
     * Scrolls the window to the very top.
     */
    public void scrollToTop() {
        js.executeScript("window.scrollTo(0, 0);");
    }

    public void scrollDown() {
        scrollBy(0, 1000); // Standard generic scroll down
    }

    /**
     * Smoothly scrolls an element into the center of the viewport.
     */
    public void scrollIntoView(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    /**
     * Checks if a WebElement is currently within the visible browser viewport
     * boundaries.
     */
    public boolean isElementInViewport(WebElement element) {
        return (Boolean) js.executeScript(
                "var rect = arguments[0].getBoundingClientRect();" +
                        "return (rect.top >= 0 && rect.bottom <= (window.innerHeight || document.documentElement.clientHeight));",
                element);
    }

    /**
     * Scrolls to an element, waits until it is clickable, and clicks it.
     */
    public void click(WebElement element) {
        scrollIntoView(element);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
}
