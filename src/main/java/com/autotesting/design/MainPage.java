package com.autotesting.design;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage extends BasePage {
    
    public static final String URL = "https://automationintesting.online/";

    private final By adminButton = By.cssSelector("a[href='/admin']");
    
    public MainPage(WebDriver driver) {
        super(driver);
    }
    
    public MainPage navigateTo() {
        if (!driver.getCurrentUrl().equals(URL)) {
            driver.get(URL);
        }
        return this;
    }

    public LoginPage clickAdminButton() {
        click(adminButton);
        return new LoginPage(driver);
    }
    
}
