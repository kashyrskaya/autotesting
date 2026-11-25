package com.autotesting.factory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPageFactory extends BaseFactoryPage {
    
    private static final String URL = "https://automationintesting.online/";
    

    @FindBy (css = "a[href='/admin']")
    private WebElement adminButton;

    public MainPageFactory(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }   

    public MainPageFactory navigateTo() {
        if (!driver.getCurrentUrl().equals(URL)) {
            driver.get(URL);
        }
        return this;
    }

    public LoginPageFactory clickAdminButton() {
        adminButton.click();
        return new LoginPageFactory(driver);
    }
}
