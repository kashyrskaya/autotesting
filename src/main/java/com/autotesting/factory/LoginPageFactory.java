package com.autotesting.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory extends BaseFactoryPage {

    private static final String URL = "https://automationintesting.online/admin";  

    @FindBy(css = "input[id='username']")
    private WebElement usernameField;

    @FindBy(css = "input[id='password']")
    private WebElement passwordField;

    @FindBys({
        @FindBy(tagName = "form"),
        @FindBy(id = "doLogin")
    })
    private WebElement loginButton;

    @FindBy(css = "a[id='frontPageLink']")
    private WebElement frontPageLink;

    @FindBy(xpath = "//a[contains(text(), 'Restful Booker Platform Demo')]")
    private WebElement brandLink;

    @FindBy(xpath = "//button[contains(text(), 'Logout')]")
    private WebElement logoutButton;

    public LoginPageFactory(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPageFactory navigateTo() {
        if (!driver.getCurrentUrl().equals(URL)) {
            driver.get(URL);
        }
        return this;
    }

    public LoginPageFactory enterUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
        return this;
    }

    public LoginPageFactory enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    public AdminRoomsPageFactory clickLogin() {
        loginButton.click();
        return new AdminRoomsPageFactory(driver);
    }

    public AdminRoomsPageFactory login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        return clickLogin();
    }

    public boolean isLoginFormReady() {
        return isDisplayed(loginButton) && isEnabled(loginButton) &&
               isDisplayed(usernameField) && isEnabled(usernameField) &&
               isDisplayed(passwordField) && isEnabled(passwordField);
    }

    public boolean isLogoutButtonDisplayed() {
        return isDisplayed(logoutButton);
    }

    public MainPageFactory clickLogout() {
        if (isDisplayed(logoutButton)) {
            logoutButton.click();
        }
        return new MainPageFactory(driver);
    }
}
