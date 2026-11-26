package com.autotesting.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

public class AdminRoomsPageFactory extends BaseFactoryPage {

    public static final String URL = "https://automationintesting.online/admin/rooms";

    @FindBy(css = "a[href='/admin/rooms']")
    private WebElement roomsButton;

    @FindBy(xpath = "//button[contains(text(), 'Logout')]")
    private WebElement logoutButton;

    @FindBy(css = "button[id='createRoom']")
    private WebElement createRoomButton;

    public AdminRoomsPageFactory(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isRoomsButtonDisplayed() {
        return isDisplayed(roomsButton);
    }

    public String getCurrentUrl() {
        waitForUrl(URL);
        return driver.getCurrentUrl();
    }

    @Step("Click the Logout button")
    public MainPageFactory clickLogout() {
        logoutButton.click();
        return new MainPageFactory(driver);
    }

    public boolean isCreateRoomButtonDisplayed() {
        return isDisplayed(createRoomButton);
    }
}
