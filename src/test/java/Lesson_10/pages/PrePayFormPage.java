package Lesson_10.pages;

import Lesson_10.base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class PrePayFormPage extends BasePage {
    private final By blockTitleLocator = By.xpath("//h2[normalize-space()=\"Онлайн пополнение без комиссии\"]");
    private final By visaLogoLocator = By.xpath("//div[@class=\"pay__partners\"]//img[@alt=\"Visa\"]");
    private final By verifiedByVisaLogoLocator = By.xpath("//div[@class=\"pay__partners\"]//img[@alt=\"Verified By Visa\"]");
    private final By masterCardLogoLocator = By.xpath("//div[@class=\"pay__partners\"]//img[@alt=\"MasterCard\"]");
    private final By masterCardSecureCodeLogoLocator = By.xpath("//div[@class=\"pay__partners\"]//img[@alt=\"MasterCard Secure Code\"]");
    private final By belkartLogoLocator = By.xpath("//div[@class=\"pay__partners\"]//img[@alt=\"Белкарт\"]");
    private final By aboutServiceLinkLocator = By.xpath("//div[@class=\"pay__wrapper\"]//a[contains(text(), \"Подробнее о сервисе\")]");

    private final By serviceSelectorLocator = By.xpath("//div[@class=\"pay__form\"]//div[@class=\"select__wrapper\"]");

    // Услуги связи
    private final By connectionServiceInSelectorLocator = By.xpath("//p[contains(text(), \"Услуги связи\")]");
    private final By connectionServiceFormLocator = By.xpath("//form[@id=\"pay-connection\"]");
    private final By connectionServicePhoneNumberLocator = By.xpath(".//input[@id=\"connection-phone\"]");
    private final By connectionServiceSumLocator = By.xpath(".//input[@id=\"connection-sum\"]");
    private final By connectionServiceEmailLocator = By.xpath(".//input[@id=\"connection-email\"]");

    // Домашний интернет
    private final By internetServiceInSelectorLocator = By.xpath("//p[contains(text(), \"Домашний интернет\")]");
    private final By internetServiceFormLocator = By.xpath("//form[@id=\"pay-internet\"]");
    private final By internetServiceNumberLocator = By.xpath(".//input[@id=\"internet-phone\"]");
    private final By internetServiceSumLocator = By.xpath(".//input[@id=\"internet-sum\"]");
    private final By internetServiceEmailLocator = By.xpath(".//input[@id=\"internet-email\"]");

    // Рассрочка
    private final By instalmentServiceInSelectorLocator = By.xpath("//p[contains(text(), \"Рассрочка\")]");
    private final By instalmentServiceFormLocator = By.xpath("//form[@id=\"pay-instalment\"]");
    private final By instalmentServiceNumberLocator = By.xpath(".//input[@id=\"score-instalment\"]");
    private final By instalmentServiceSumLocator = By.xpath(".//input[@id=\"instalment-sum\"]");
    private final By instalmentServiceEmailLocator = By.xpath(".//input[@id=\"instalment-email\"]");

    // Задолженность
    private final By arrearsServiceInSelectorLocator = By.xpath("//p[contains(text(), \"Задолженность\")]");
    private final By arrearsServiceFormLocator = By.xpath("//form[@id=\"pay-arrears\"]");
    private final By arrearsServiceNumberLocator = By.xpath(".//input[@id=\"score-arrears\"]");
    private final By arrearsServiceSumLocator = By.xpath(".//input[@id=\"arrears-sum\"]");
    private final By arrearsServiceEmailLocator = By.xpath(".//input[@id=\"arrears-email\"]");

    private final By submitButtonLocator = By.xpath(".//button[text()=\"Продолжить\"]");
    private final By paymentIFrameLocator = By.xpath("//iframe[@class=\"bepaid-iframe\"]");

    public PrePayFormPage(WebDriver webDriver, WebDriverWait wait) {
        super(webDriver,wait);
    }

    public By getConnectionServiceFormLocator() {
        return connectionServiceFormLocator;
    }

    public By getInternetServiceFormLocator() {
        return internetServiceFormLocator;
    }

    public By getInstalmentServiceFormLocator() {
        return instalmentServiceFormLocator;
    }

    public By getArrearsServiceFormLocator() {
        return arrearsServiceFormLocator;
    }

    public By getPaymentIFrameLocator() {
        return paymentIFrameLocator;
    }

    public String getBlockTitle() {
        return webDriver.findElement(blockTitleLocator).getText().replace("\n", " ").trim();
    }

    public Map<By, String> getConnectionServiceFormPlaceholders() {
        return Map.of(
                connectionServicePhoneNumberLocator, "Номер телефона",
                connectionServiceSumLocator, "Сумма",
                connectionServiceEmailLocator, "E-mail для отправки чека"
        );
    }

    public Map<By, String> getInternetServiceFormPlaceholders() {
        return Map.of(
                internetServiceNumberLocator, "Номер абонента",
                internetServiceSumLocator, "Сумма",
                internetServiceEmailLocator, "E-mail для отправки чека"
        );
    }

    public Map<By, String> getInstalmentServiceFormPlaceholders() {
        return Map.of(
                instalmentServiceNumberLocator, "Номер счета на 44",
                instalmentServiceSumLocator, "Сумма",
                instalmentServiceEmailLocator, "E-mail для отправки чека"
        );
    }

    public Map<By, String> getArrearsServiceFormPlaceholders() {
        return Map.of(
                arrearsServiceNumberLocator, "Номер счета на 2073",
                arrearsServiceSumLocator, "Сумма",
                arrearsServiceEmailLocator, "E-mail для отправки чека"
        );
    }

    public void selectPrePayFormByLocator(By formLocator) {
        By chosenSelect;

        if (formLocator.equals(connectionServiceFormLocator)) {
            chosenSelect = connectionServiceInSelectorLocator;
        } else if (formLocator.equals(internetServiceFormLocator)) {
            chosenSelect = internetServiceInSelectorLocator;
        } else if (formLocator.equals(instalmentServiceFormLocator)) {
            chosenSelect = instalmentServiceInSelectorLocator;
        } else if (formLocator.equals(arrearsServiceFormLocator)) {
            chosenSelect = arrearsServiceInSelectorLocator;
        } else {
            throw new IllegalArgumentException("Неизвестный локатор формы: " + formLocator);
        }

        wait.until(ExpectedConditions.elementToBeClickable(serviceSelectorLocator)).click();
        wait.until(ExpectedConditions.elementToBeClickable(chosenSelect)).click();

        WebElement form = wait.until(ExpectedConditions.presenceOfElementLocated(formLocator));
        WebElement firstInput = wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(form, By.tagName("input"))).get(0);

        if (firstInput.isDisplayed() == false) {
            throw new IllegalStateException("Форма " + formLocator + " открыта, но поля не отображаются!");
        }
    }

    public void checkPlaceholders(By formLocator, Map<By, String> expectedPlaceholders) {
        selectPrePayFormByLocator(formLocator);

        WebElement form = wait.until(ExpectedConditions.presenceOfElementLocated(formLocator));

        expectedPlaceholders.forEach((fieldLocator, expected) -> {
            WebElement field = wait.until(
                    ExpectedConditions.visibilityOf(form.findElement(fieldLocator))
            );

            String actualPlaceholder = field.getAttribute("placeholder");

            if (expected.equals(actualPlaceholder) == false) {
                throw new IllegalArgumentException("Placeholder для поля " + fieldLocator + " не совпадает с ожидаемым\n" +
                        "Ожидалось " + expected + " вместо " + actualPlaceholder);
            }
        });
    }

    public boolean isVisaLogoDisplayed() {
        try {
            return webDriver.findElement(visaLogoLocator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isVerifiedByVisaLogoDisplayed() {
        try {
            return webDriver.findElement(verifiedByVisaLogoLocator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isMasterCardLogoDisplayed() {
        try {
            return webDriver.findElement(masterCardLogoLocator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isMasterCardSecureCodeLogoDisplayed() {
        try {
            return webDriver.findElement(masterCardSecureCodeLogoLocator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isBelkartLogoDisplayed() {
        try {
            return webDriver.findElement(belkartLogoLocator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickAboutServiceLink() {
        wait.until(ExpectedConditions.elementToBeClickable((aboutServiceLinkLocator))).click();
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public void fillConnectionServicePaymentForm(String number, String sum, String email) {
        actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(connectionServicePhoneNumberLocator)))
                .click()
                .sendKeys(number)
                .perform();
        actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(connectionServiceSumLocator)))
                .click()
                .sendKeys(sum)
                .perform();
        actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(connectionServiceEmailLocator)))
                .click()
                .sendKeys(email)
                .perform();
    }


    private WebElement getSubmitButtonLocator(By formLocator) {
        return webDriver.findElement(formLocator).findElement(submitButtonLocator);
    }

    public void clickSubmitButton(By formLocator) {
        actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(getSubmitButtonLocator(formLocator))))
                .click()
                .perform();
    }

    public boolean isIFrameDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(paymentIFrameLocator)).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}