package com.autotesting.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

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

    @Step("Navigate to the login page")
    public LoginPageFactory navigateTo() {
        if (!driver.getCurrentUrl().equals(URL)) {
            driver.get(URL);
        }
        return this;
    }

    @Step("Enter username: {username}")
    public LoginPageFactory enterUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
        return this;
    }

    @Step("Enter password: {password}")
    public LoginPageFactory enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    @Step("Click the Login button")
    public AdminRoomsPageFactory clickLogin() {
        loginButton.click();
        return new AdminRoomsPageFactory(driver);
    }

    @Step("Perform login with username: {username} and password: {password}")
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

    @Step("Click the Logout button")
    public MainPageFactory clickLogout() {
        if (isDisplayed(logoutButton)) {
            logoutButton.click();
        }
        return new MainPageFactory(driver);
    }
}
