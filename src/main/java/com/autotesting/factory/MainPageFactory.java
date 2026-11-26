package com.autotesting.factory;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.qameta.allure.Step;

public class MainPageFactory extends BaseFactoryPage {

    public static final String URL = "https://automationintesting.online/";

    @FindBy(css = "a[href='#booking']")
    private WebElement heroBookNowButton;

    @FindBy(xpath = "//h2[contains(text(), 'Our Rooms')]")
    private WebElement ourRoomsHeader;

    @FindBy(css = "a[href*='/reservation/']")
    private List<WebElement> roomBookNowButtons;

    // Nav bar elements
    @FindBy(css = "a.navbar-brand")
    private WebElement navbarBrandLogo;

    @FindBy(css = "a[href='/admin']")
    private WebElement adminButton;

    @FindBy(css = "a[href='/#contact']")
    private WebElement contactNavLink;

    // Contact form
    @FindBy(id = "contact")
    private WebElement contactSection;

    @FindBy(id = "name")
    private WebElement contactNameInput;

    @FindBy(id = "email")
    private WebElement contactEmailInput;

    @FindBy(id = "phone")
    private WebElement contactPhoneInput;

    @FindBy(id = "subject")
    private WebElement contactSubjectInput;

    @FindBy(id = "description")
    private WebElement contactMessageInput;

    @FindBy(xpath = "//section[@id='contact']//button[contains(text(), 'Submit')]")
    private WebElement contactSubmitButton;

    @FindBy(css = ".alert.alert-danger p")
    private List<WebElement> contactValidationMessages;

    public MainPageFactory(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Navigate to the main page")
    public MainPageFactory navigateTo() {
        if (!driver.getCurrentUrl().equals(URL)) {
            driver.get(URL);
        }
        return this;
    }

    @Step("Click the Admin button")
    public LoginPageFactory clickAdminButton() {
        adminButton.click();
        return new LoginPageFactory(driver);
    }

    public String getCurrentUrl() {
        waitForUrl(URL);
        return driver.getCurrentUrl();
    }

    public boolean isHeroBookNowButtonDisplayed() {
        return isDisplayed(heroBookNowButton);
    }

    public MainPageFactory clickHeroBookNowButton() {
        heroBookNowButton.click();
        return this;
    }

    public boolean isOurRoomsHeaderDisplayed() {
        return isDisplayed(ourRoomsHeader);
    }

    @Step ("Click a random 'Book Now' button for available rooms")
    public ReservationPageFactory clickRandomRoomBookNowButton() {
        wait.until(ExpectedConditions.visibilityOfAllElements(roomBookNowButtons));
        if (roomBookNowButtons.isEmpty()) {
            throw new IllegalStateException("No rooms available to book!");
        }
        int randomIndex = new Random().nextInt(roomBookNowButtons.size());
        WebElement selectedButton = roomBookNowButtons.get(randomIndex);

        click(selectedButton);
        return new ReservationPageFactory(driver);
    }
}
