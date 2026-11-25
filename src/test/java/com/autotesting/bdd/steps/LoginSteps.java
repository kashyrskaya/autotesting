package com.autotesting.bdd.steps;

    import com.autotesting.bdd.hooks.Hooks;
    import com.autotesting.factory.AdminRoomsPageFactory;
    import com.autotesting.factory.LoginPageFactory;
    import com.autotesting.factory.MainPageFactory;
    import io.cucumber.java.en.And;
    import io.cucumber.java.en.Given;
    import io.cucumber.java.en.Then;
    import io.cucumber.java.en.When;
    import org.openqa.selenium.WebDriver;

    import static org.assertj.core.api.Assertions.assertThat;


public class LoginSteps {

    private WebDriver driver;
    private MainPageFactory mainPage;
    private LoginPageFactory loginPage;
    private AdminRoomsPageFactory adminRoomsPage;

    public LoginSteps() {
        this.driver = Hooks.getDriver();
    }

    @Given("the user navigates directly to the admin login page")
    public void userNavigatesToAdminLogin() {
        loginPage = new LoginPageFactory(driver);
        loginPage.navigateTo();
    }

    @When("the user enters username {string} and password {string}")
    public void userEntersCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("clicks the login button")
    public void userClicksLogin() {
        adminRoomsPage = loginPage.clickLogin();
    }

    @Then("the user should be redirected to the admin rooms dashboard")
    public void verifyRedirectToRoomsDashboard() {
        assertThat(adminRoomsPage.getCurrentUrl()).isEqualTo(AdminRoomsPageFactory.URL);
    }

    @And("the rooms navigation button should be visible")
    public void verifyRoomsButtonDisplayed() {
        assertThat(adminRoomsPage.isRoomsButtonDisplayed()).isTrue();
    }

    @Given("the user is on the hotel public home page")
    public void userIsOnHomePage() {
        mainPage = new MainPageFactory(driver);
        mainPage.navigateTo();
    }

    @When("the user clicks the admin link in the navigation header")
    public void userClicksAdminLink() {
        loginPage = mainPage.clickAdminButton();
    }

    @Then("the admin login form should be ready with all required elements")
    public void verifyLoginFormReady() {
        assertThat(loginPage.isLoginFormReady()).isTrue();
    }
}
