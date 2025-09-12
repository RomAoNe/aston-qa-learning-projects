package Lesson_10.pages;

import Lesson_10.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PayFormPage extends BasePage {
    private final By topSumLocator = By.xpath("//div[@class=\"pay-description__cost\"]/span");
    private final By buttonSumLocator = By.xpath("//div[@class=\"card-page__card\"]//button[contains(text(),\"Оплатить\")]");

    private final By phoneLocator = By.xpath("//div[@class=\"pay-description__text\"]//span[contains(text(),\"Номер:\")]");

    private final By cardNumberLabelLocator = By.xpath("//input[@id=\"cc-number\"]/following-sibling::label");
    private final By expiryLabelLocator = By.xpath("//input[@autocomplete=\"cc-exp\"]/following-sibling::label");
    private final By cvcLabelLocator = By.xpath("//input[@autocomplete=\"cc-csc\"]/following-sibling::label");
    private final By nameLabelLocator = By.xpath("//input[@autocomplete=\"cc-name\"]/following-sibling::label");

    private final By visaLogoLocator = By.xpath("//img[@src=\"assets/images/payment-icons/card-types/visa-system.svg\"]");
    private final By masterCardLogoLocator = By.xpath("//img[@src=\"assets/images/payment-icons/card-types/mastercard-system.svg\"]");
    private final By belkartLogoLocator = By.xpath("//img[@src=\"assets/images/payment-icons/card-types/belkart-system.svg\"]");
    private final By maestroLogoLocator = By.xpath("//div[contains(@class, \"cards-brands_random\")]//img[1]");
    private final By mirLogoLocator = By.xpath("//div[contains(@class, \"cards-brands_random\")]//img[2]");

    public PayFormPage(WebDriver webDriver, WebDriverWait wait) {
        super(webDriver, wait);
    }

    @Step("Переключаемся на iFrame платежной формы")
    public void switchToFrame(By iframeLocator) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeLocator));
    }

    @Step("Переключаеся обрато на главную страницу")
    public void switchBack() {
        webDriver.switchTo().defaultContent();
    }

    @Step("Получаем значение суммы в хедере кнопки")
    public String getTopSumValue() {
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(topSumLocator)).getText();
        return text.replaceAll("[^0-9,.]", "");
    }

    @Step("Получаем значениее суммы в кнопке формы")
    public String getButtonSumValue() {
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(buttonSumLocator)).getText();
        return text.replaceAll("[^0-9,.]", "");
    }

    @Step("Получаем значеие телефона в хедере")
    public String getPhone() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(phoneLocator)).getText();
    }

    @Step("Получаем локатор лейбла от поля \"Номер карты\"")
    public String getCardNumberLabelLocator() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumberLabelLocator)).getText();
    }

    @Step("Получаем локатор лейбла от поля \"Срок действия карты\"")
    public String getExpiryLabelLocator() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(expiryLabelLocator)).getText();
    }

    @Step("Получаем локатор лейбла от поля \"CVC\"")
    public String getCvcLabelLocator() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cvcLabelLocator)).getText();
    }

    @Step("Получаем локатор лейбла от поля \"Имя и фамилия на карте\"")
    public String getNameLabelLocator() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(nameLabelLocator)).getText();
    }

    @Step("Проверяем отображается ли логотип Visa")
    public boolean isVisaLogoDisplayed() {
        return isDisplayed(visaLogoLocator);
    }

    @Step("Проверяем отображается ли логотип Master Card")
    public boolean isMasterCardLogoDisplayed() {
        return isDisplayed(masterCardLogoLocator);
    }

    @Step("Проверяем отображается ли логотип Белкарт")
    public boolean isBelkartLogoDisplayed() {
        return isDisplayed(belkartLogoLocator);
    }

    @Step("Проверяем отображается ли логотип Maestro")
    public boolean isMaestroLogoDisplayed() {
        return isDisplayed(maestroLogoLocator);
    }

    @Step("Проверяем отображается ли логотип Мир")
    public boolean isMirLogoDisplayed() {
        return isDisplayed(mirLogoLocator);
    }

    @Step("Вызываем метод, проверяющий, по локатору, отображается ли элемент")
    private boolean isDisplayed(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }
}