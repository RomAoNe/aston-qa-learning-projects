package Lesson_10.base;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BaseTest {
    protected WebDriver webDriver;
    protected WebDriverWait wait;

    public BaseTest(){
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    @BeforeEach
    void setUp() {
        webDriver.get("http://mts.by/");

        WebElement agreeCookie = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id=\"cookie-agree\"]")));
        if (agreeCookie.isDisplayed()) {
            agreeCookie.click();
        }
    }

    @AfterEach
    void closeWindow() {
        webDriver.quit();
    }
}
