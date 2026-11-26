package com.autotesting;

import com.autotesting.factory.LoginPageFactory;
import com.autotesting.factory.AdminRoomsPageFactory;
import com.autotesting.factory.MainPageFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Defect Verification & Bug Reports Suite")
public class BugReportTest extends BaseTest {

    private LoginPageFactory loginPage;

    @BeforeEach 
    void setUpTest() {
        loginPage = new LoginPageFactory(driver);
        loginPage.navigateTo();
    }

    @Test 
    @DisplayName("BUG-02: Verify Logout button is not visible for unauthentucated users on the admin login page")
    void testLogoutButtonNotVisibleForUnauthenticatedUsers() {
        assertThat(loginPage.isLogoutButtonDisplayed())
            .as("Defect BUG-02")
            .isFalse();
    }

    @Test 
    @DisplayName("BUG-01: Admin Dashboard should not be accessible without authentication")
    void testAdminDashboardNotAccessibleWithoutAuthentication() {
        AdminRoomsPageFactory adminRoomsPage = loginPage.login("admin", "password");
        assertThat(adminRoomsPage.isRoomsButtonDisplayed()).isTrue();

        MainPageFactory mainPage = adminRoomsPage.clickLogout();
        assertThat(mainPage.getCurrentUrl()).isEqualTo(MainPageFactory.URL);

        driver.navigate().back();

        assertThat(adminRoomsPage.isCreateRoomButtonDisplayed())
            .as("Defect BUG-01")
            .isFalse();
    }
}
