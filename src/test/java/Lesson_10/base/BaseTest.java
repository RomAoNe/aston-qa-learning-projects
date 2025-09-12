package Lesson_10.base;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
    protected WebDriver webDriver;
    protected WebDriverWait wait;

    public BaseTest() {
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    @BeforeEach
    void setUp() {
        webDriver.get("http://mts.by/");

        try {
            WebElement agreeCookie = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id=\"cookie-agree\"]")));
            if (agreeCookie.isDisplayed()) {
                agreeCookie.click();
            }
        } catch (TimeoutException ignored) {
            // Игнорирруем, если "Принять куки" не появилось
        }

        try {
            WebElement helpWidget = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@class, \"webim-button-corner\")]")));
            if (helpWidget.isDisplayed()) {
                ((JavascriptExecutor) webDriver).executeScript("arguments[0].style.display='none';", helpWidget);
            }
        } catch (TimeoutException ignored) {
            // Игнорировать, если "Помощь" не появилась
        }
    }

    @AfterEach
    void closeWindow() {
        webDriver.quit();
    }
}