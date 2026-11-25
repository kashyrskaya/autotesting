package com.autotesting;

import com.autotesting.design.LoginPage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * UI Smoke test suite for Task 1:
 * Covers the login section of https://automationintesting.online/
 * Credentials: admin / password
 */
public class LoginSmokeTest extends BaseUiTest {

    @Test
    @Disabled("To be implemented as part of Task 1 automation")
    @DisplayName("Smoke Test: Successful login with valid credentials")
    void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("admin", "password");

        // TODO: Assert post-login state (e.g., logout button visible, admin dashboard header)
    }

    @Test
    @Disabled("To be implemented as part of Task 1 automation")
    @DisplayName("Smoke Test: Login form elements presence")
    void testLoginFormElementsPresent() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();

        assertThat(loginPage.isLoginButtonDisplayed()).isTrue();
    }
}
