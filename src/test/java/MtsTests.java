import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class MtsTests {
    private WebDriver webDriver;
    private WebDriverWait wait;

    @BeforeEach
    void setUp() {
        webDriver = new ChromeDriver();
        webDriver.get("http://mts.by/");
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        WebElement agreeCookie = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id=\"cookie-agree\"]")));
        if (agreeCookie.isDisplayed()) {
            agreeCookie.click();
        }
    }

    @AfterEach
    void closeWindow() {
        webDriver.quit();
    }

    @Test
    @DisplayName("Блок называется \"Онлайн пополнение без комиссии\"")
    void testBlockTitle() {
        WebElement element = webDriver.findElement(By.xpath("//h2[normalize-space()=\"Онлайн пополнение без комиссии\"]"));
        String elementTitle = element.getText().replace("\n", " ").trim();
        assertEquals("Онлайн пополнение без комиссии", elementTitle);
    }

    @Test
    @DisplayName("На странице отображаются логотипы платежных систем")
    void testLogosDisplayed() {
        assertTrue(webDriver.findElement(By.xpath("//div[@class=\"pay__partners\"]//img[@alt=\"Visa\"]")).isDisplayed());
        assertTrue(webDriver.findElement(By.xpath("//div[@class=\"pay__partners\"]//img[@alt=\"Verified By Visa\"]")).isDisplayed());
        assertTrue(webDriver.findElement(By.xpath("//div[@class=\"pay__partners\"]//img[@alt=\"MasterCard\"]")).isDisplayed());
        assertTrue(webDriver.findElement(By.xpath("//div[@class=\"pay__partners\"]//img[@alt=\"MasterCard Secure Code\"]")).isDisplayed());
        assertTrue(webDriver.findElement(By.xpath("//div[@class=\"pay__partners\"]//img[@alt=\"Белкарт\"]")).isDisplayed());
    }

    @Test
    @DisplayName("Клик по ссылке \"Подробнее о сервисе\" ведёт на страницу \"Порядок оплаты и безопасность интернет платежей\"")
    void testLinkDetails() {
        WebElement link = webDriver.findElement(By.xpath("//div[@class=\"pay__wrapper\"]//a[contains(text(), \"Подробнее о сервисе\")]"));
        link.click();

        String currentUrl = webDriver.getCurrentUrl();
        assertNotNull(currentUrl);
        assertTrue(currentUrl.contains("poryadok-oplaty-i-bezopasnost-internet-platezhey"));
    }

    @Test
    @DisplayName("При заполненных полях формы, кнопка продолжить \"Продолжить\" открывает модальное окно для ввода реквизитов")
    void testButton() {
        WebElement phoneNumber = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@id=\"connection-phone\"]")));
        WebElement sum = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@id=\"connection-sum\"]")));
        WebElement email = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@id=\"connection-email\"]")));
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//form[@id=\"pay-connection\"]//button[text()=\"Продолжить\"]")));

        phoneNumber.click();
        phoneNumber.sendKeys("297777777");
        sum.click();
        sum.sendKeys("50");
        email.click();
        email.sendKeys("guvpeo@tempinbox.xyz");
        submitButton.click();

        WebElement paymentInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//iframe[@class=\"bepaid-iframe\"]")));
        assertTrue(paymentInfo.isDisplayed());
    }
}