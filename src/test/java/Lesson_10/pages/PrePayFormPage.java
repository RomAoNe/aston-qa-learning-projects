package Lesson_10.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class PrePayFormPage {
    By blockTitleLocator = By.xpath("//h2[normalize-space()=\"Онлайн пополнение без комиссии\"]");
    By visaLogoLocator = By.xpath("//div[@class=\"pay__partners\"]//img[@alt=\"Visa\"]");
    By verifiedByVisaLogoLocator = By.xpath("//div[@class=\"pay__partners\"]//img[@alt=\"Verified By Visa\"]");
    By masterCardLogoLocator = By.xpath("//div[@class=\"pay__partners\"]//img[@alt=\"MasterCard\"]");
    By masterCardSecureCodeLogoLocator = By.xpath("//div[@class=\"pay__partners\"]//img[@alt=\"MasterCard Secure Code\"]");
    By belkartLogoLocator = By.xpath("//div[@class=\"pay__partners\"]//img[@alt=\"Белкарт\"]");
    By aboutServiceLinkLocator = By.xpath("//div[@class=\"pay__wrapper\"]//a[contains(text(), \"Подробнее о сервисе\")]");

    By serviceSelectorLocator = By.xpath("//div[@class=\"pay__form\"]//div[@class=\"select__wrapper\"]");

    // Услуги связи
    By connectionServiceInSelectorLocator = By.xpath("//p[contains(text(), \"Услуги связи\")]");
    By connectionServiceFormLocator = By.xpath("//form[@id=\"pay-connection\"]");
    By connectionServicePhoneNumberLocator = By.xpath(".//input[@id=\"connection-phone\"]");
    By connectionServiceSumLocator = By.xpath(".//input[@id=\"connection-sum\"]");
    By connectionServiceEmailLocator = By.xpath(".//input[@id=\"connection-email\"]");

    // Домашний интернет
    By internetServiceInSelectorLocator = By.xpath("//p[contains(text(), \"Домашний интернет\")]");
    By internetServiceFormLocator = By.xpath("//form[@id=\"pay-internet\"]");
    By internetServiceNumberLocator = By.xpath(".//input[@id=\"internet-phone\"]");
    By internetServiceSumLocator = By.xpath(".//input[@id=\"internet-sum\"]");
    By internetServiceEmailLocator = By.xpath(".//input[@id=\"internet-email\"]");

    // Рассрочка
    By instalmentServiceInSelectorLocator = By.xpath("//p[contains(text(), \"Рассрочка\")]");
    By instalmentServiceFormLocator = By.xpath("//form[@id=\"pay-instalment\"]");
    By instalmentServiceNumberLocator = By.xpath(".//input[@id=\"score-instalment\"]");
    By instalmentServiceSumLocator = By.xpath(".//input[@id=\"instalment-sum\"]");
    By instalmentServiceEmailLocator = By.xpath(".//input[@id=\"instalment-email\"]");

    // Задолженность
    By arrearsServiceInSelectorLocator = By.xpath("//p[contains(text(), \"Задолженность\")]");
    By arrearsServiceFormLocator = By.xpath("//form[@id=\"pay-arrears\"]");
    By arrearsServiceNumberLocator = By.xpath(".//input[@id=\"score-arrears\"]");
    By arrearsServiceSumLocator = By.xpath(".//input[@id=\"arrears-sum\"]");
    By arrearsServiceEmailLocator = By.xpath(".//input[@id=\"arrears-email\"]");

    By submitButtonLocator = By.xpath(".//button[text()=\"Продолжить\"]");
    By paymentIFrameLocator = By.xpath("//iframe[@class=\"bepaid-iframe\"]");

    private WebDriver webDriver;
    private WebDriverWait wait;
    private Actions actions;

    public PrePayFormPage(WebDriver webDriver, WebDriverWait wait) {
        this.webDriver = webDriver;
        this.wait = wait;
        this.actions = new Actions(webDriver);
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