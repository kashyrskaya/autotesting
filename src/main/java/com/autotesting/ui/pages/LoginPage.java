package com.autotesting.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public static final String URL = "https://automationintesting.online/admin";

    private final By usernameField = By.cssSelector("input[id='username']");
    private final By passwordField = By.cssSelector("input[id='password']");
    private final By loginButton = By.cssSelector("button[id='doLogin']");
    private final By logoutButton = By.xpath("//button[contains(text(), 'Logout')]");
    private final By frontpageLink = By.cssSelector("a[id='frontPageLink']");
    private final By brandLink = By.xpath("//a[contains(text(), 'Restful Booker Platform Demo')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        driver.get(URL);
        return this;
    }

    public LoginPage enterUsername(String username) {
        type(usernameField, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        type(passwordField, password);
        return this;
    }

    public void clickLogin() {
        click(loginButton);
    }

    public void clickLogout() {
        click(logoutButton);
    }

    public void clickFrontPage() {
        click(frontpageLink);
    }

    public void clickBrand() {
        click(brandLink);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public boolean isLoginButtonDisplayed() {
        return isDisplayed(loginButton);
    }
}
