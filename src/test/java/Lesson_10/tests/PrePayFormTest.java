package Lesson_10.tests;

import Lesson_10.base.BaseTest;
import Lesson_10.pages.PrePayFormPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrePayFormTest extends BaseTest {
    PrePayFormPage prePayFormPage = new PrePayFormPage(webDriver, wait );

    @Test
    @DisplayName("\"Блок называется \"Онлайн пополнение без комиссии\"\"")
    void testBlockTitle(){
        assertEquals("Онлайн пополнение без комиссии", prePayFormPage.getBlockTitle());
    }

    @Test
    @DisplayName("На странице отображаются логотипы платежных систем")
    void testPaymentSystemsLogosDisplayed(){
        assertTrue(prePayFormPage.isVisaLogoDisplayed(), "Логотип Visa не отображается");
        assertTrue(prePayFormPage.isVerifiedByVisaLogoDisplayed());
        assertTrue(prePayFormPage.isMasterCardLogoDisplayed());
        assertTrue(prePayFormPage.isMasterCardSecureCodeLogoDisplayed());
        assertTrue(prePayFormPage.isBelcartLogoDisplayed());
    }

    @Test
    @DisplayName("Клик по ссылке \"Подробнее о сервисе\" ведёт на страницу \"Порядок оплаты и безопасность интернет платежей\"")
    void testClickAboutServiceLink(){
        prePayFormPage.clickAboutServiceLink();
        assertTrue(prePayFormPage.getCurrentUrl().contains("poryadok-oplaty-i-bezopasnost-internet-platezhey"));
    }

    @Test
    @DisplayName("При заполненных полях формы \"Услуги связи\", кнопка \"Продолжить\" открывает модальное окно для ввода реквизитов")
    void testSubmitButtonWhenFormIsFilled(){
        prePayFormPage.fillConnectionServicePaymentForm("297777777", "50", "guvpeo@tempinbox.xyz");
        prePayFormPage.clickSubmitButton(prePayFormPage.getConnectionServiceFormLocator());
        assertTrue(prePayFormPage.isIFrameDisplayed());
    }
}