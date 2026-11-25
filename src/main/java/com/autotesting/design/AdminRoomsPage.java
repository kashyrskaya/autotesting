package com.autotesting.design;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminRoomsPage extends BasePage {
    
    public static final String URL = "https://automationintesting.online/admin/rooms";

    private final By roomsButton = By.cssSelector("a[href='/admin/rooms']");
    
    public AdminRoomsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isRoomsButtonDisplayed() {
        return isDisplayed(roomsButton);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
