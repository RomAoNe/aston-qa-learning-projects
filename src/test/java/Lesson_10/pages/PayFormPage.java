package Lesson_10.pages;

import Lesson_10.base.BasePage;
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

    public void switchToFrame(By iframeLocator) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeLocator));
    }

    public void switchBack() {
        webDriver.switchTo().defaultContent();
    }

    public String getTopSumValue() {
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(topSumLocator)).getText();
        return text.replaceAll("[^0-9,.]", "");
    }

    public String getButtonSumValue() {
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(buttonSumLocator)).getText();
        return text.replaceAll("[^0-9,.]", "");
    }

    public String getPhone() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(phoneLocator)).getText();
    }

    public String getCardNumberLabelLocator() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumberLabelLocator)).getText();
    }

    public String getExpiryLabelLocator() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(expiryLabelLocator)).getText();
    }

    public String getCvcLabelLocator() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cvcLabelLocator)).getText();
    }

    public String getNameLabelLocator() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(nameLabelLocator)).getText();
    }

    public boolean isVisaLogoDisplayed() {
        return isDisplayed(visaLogoLocator);
    }

    public boolean isMasterCardLogoDisplayed() {
        return isDisplayed(masterCardLogoLocator);
    }

    public boolean isBelkartLogoDisplayed() {
        return isDisplayed(belkartLogoLocator);
    }

    public boolean isMaestroLogoDisplayed() {
        return isDisplayed(maestroLogoLocator);
    }

    public boolean isMirLogoDisplayed() {
        return isDisplayed(mirLogoLocator);
    }

    private boolean isDisplayed(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }
}