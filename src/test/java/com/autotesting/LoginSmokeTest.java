package com.autotesting;

import com.autotesting.factory.LoginPageFactory;
import com.autotesting.factory.MainPageFactory;
import com.autotesting.factory.AdminRoomsPageFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSmokeTest extends BaseTest {

    private LoginPageFactory loginPage;
    private MainPageFactory mainPage;
    private AdminRoomsPageFactory adminRoomsPage;
    @BeforeEach
    void setUpTest() {
        loginPage = new LoginPageFactory(driver);
    }

    @Test
    @DisplayName("Smoke Test - TC-01: Login form elements presence")
    void testLoginFormElementsPresent() {
        mainPage = new MainPageFactory(driver);
        loginPage = mainPage.navigateTo().clickAdminButton();

        assertThat(loginPage.isLoginFormReady()).isTrue();
    }

    @Test
    @DisplayName("Smoke Test - TC-02: Successful login with valid credentials")
    void testSuccessfulLogin() {
        loginPage.navigateTo();
        adminRoomsPage = loginPage.login("admin", "password");

        assertThat(adminRoomsPage.isRoomsButtonDisplayed()).isTrue();
        assertThat(adminRoomsPage.getCurrentUrl()).isEqualTo(AdminRoomsPageFactory.URL);
    }
}
