package com.autotesting.core.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

/**
 * Factory class for creating and configuring WebDriver instances.
 */
public class WebDriverFactory {

    private static final Duration DEFAULT_IMPLICIT_WAIT = Duration.ofSeconds(10);
    private static final Duration DEFAULT_PAGE_LOAD_TIMEOUT = Duration.ofSeconds(30);

    /**
     * Creates a WebDriver instance based on browser name.
     *
     * @param browser "chrome" or "firefox"
     * @param headless whether to run in headless mode
     * @return configured WebDriver
     */
    public static WebDriver createDriver(String browser, boolean headless) {
        WebDriver driver;

        if (browser == null) {
            browser = "chrome";
        }

        switch (browser.toLowerCase().trim()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (headless) {
                    firefoxOptions.addArguments("-headless");
                }
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if (headless) {
                    chromeOptions.addArguments("--headless=new");
                }
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.addArguments("--window-size=1920,1080");
                driver = new ChromeDriver(chromeOptions);
                break;
        }

        driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICIT_WAIT);
        driver.manage().timeouts().pageLoadTimeout(DEFAULT_PAGE_LOAD_TIMEOUT);
        driver.manage().window().maximize();

        return driver;
    }

    public static WebDriver createDriver() {
        // Default to chrome non-headless or via system property
        String browser = System.getProperty("browser", "chrome");
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
        return createDriver(browser, headless);
    }
}
