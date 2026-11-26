package com.autotesting.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

public class MainPageFactory extends BaseFactoryPage {

    public static final String URL = "https://automationintesting.online/";

    @FindBy(css = "a[href='/admin']")
    private WebElement adminButton;

    public MainPageFactory(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Navigate to the main page")
    public MainPageFactory navigateTo() {
        if (!driver.getCurrentUrl().equals(URL)) {
            driver.get(URL);
        }
        return this;
    }

    @Step("Click the Admin button")
    public LoginPageFactory clickAdminButton() {
        adminButton.click();
        return new LoginPageFactory(driver);
    }

    public String getCurrentUrl() {
        waitForUrl(URL);
        return driver.getCurrentUrl();
    }
}
