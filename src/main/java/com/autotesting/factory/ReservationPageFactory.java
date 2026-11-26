package com.autotesting.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReservationPageFactory extends BaseFactoryPage {

    @FindBy(xpath = "//h2[contains(text(),'Room Description')]/following-sibling::p")
    private WebElement roomDescriptionParagraph;

    @FindBy(id = "doReservation")
    private WebElement ReserveNowButton;

    public ReservationPageFactory(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //TO-DO: move out reservation page URL to a constant
    public boolean isUrlValid() {
        return waitForUrlContains("/reservation/");
    }

    public boolean isRoomDescriptionDisplayed() {
        return isDisplayed(roomDescriptionParagraph);
    }

    public boolean isReserveNowButtonDisplayed() {
        return isDisplayed(ReserveNowButton);
    }

}
