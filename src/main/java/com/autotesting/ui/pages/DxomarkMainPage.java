package com.autotesting.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DxomarkMainPage extends BasePage {

    public static final String URL = "https://www.dxomark.com/";

    private final By learnMoreLink = By.xpath("//a[contains(text(), 'Learn more here')]");
    private final By articlesItem = By.xpath("//a[contains(text(), 'Articles')]");
    private final By bestOfLink = By.xpath("//a[contains(text(), 'Best of')]");

    public DxomarkMainPage(WebDriver driver) {
        super(driver);
    }

    public DxomarkMainPage open() {
        driver.get(URL);
        return this;
    }

    public void clickLearnMore() {
        click(learnMoreLink);
    }

    public void hoverArticles() {
        WebElement activeItem = driver.findElements(articlesItem).stream()
                .filter(el -> el != null && el.isDisplayed())
                .findFirst()
                .orElse(null);

        hover(activeItem);
    }

    public void clickBestOf() {
        hoverArticles();
        WebElement activeLink = wait.until(d -> driver.findElements(bestOfLink).stream()
                .filter(el -> el != null && el.isDisplayed())
                .findFirst()
                .orElse(null));

        activeLink.click();
    }
}
