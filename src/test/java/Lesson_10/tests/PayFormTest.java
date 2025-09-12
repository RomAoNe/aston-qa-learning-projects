package Lesson_10.tests;

import Lesson_10.base.BaseTest;
import Lesson_10.pages.PayFormPage;
import Lesson_10.pages.PrePayFormPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PayFormTest extends BaseTest {
    PrePayFormPage prePayFormPage;
    PayFormPage payFormPage;

    @BeforeEach
    void initPage() {
        prePayFormPage = new PrePayFormPage(webDriver, wait);
        payFormPage = new PayFormPage(webDriver, wait);

        prePayFormPage.fillConnectionServicePaymentForm("297777777", "50.00", "guvpeo@tempinbox.xyz");
        prePayFormPage.clickSubmitButton(prePayFormPage.getConnectionServiceFormLocator());

        payFormPage.switchToFrame(prePayFormPage.getPaymentIFrameLocator());
    }

    @AfterEach
    void switchBack() {
        payFormPage.switchBack();
    }

    @Test
    @DisplayName("Суммы в форме отображаются корректно")
    void testPrePayFormIFrame() {
        assertEquals("50.00", payFormPage.getTopSumValue());
        assertTrue(payFormPage.getButtonSumValue().contains("50.00"));
    }

    @Test
    @DisplayName("Номер телефона в хедере формы отображается корректно")
    void testPhoneDisplayedCorrectly() {
        assertTrue(payFormPage.getPhone().contains("375297777777"));
    }

    @Test
    @DisplayName("Лейблы полей соответствуют ожидаемым")
    void testLabelsDisplayedCorrectly() {
        assertEquals("Номер карты", payFormPage.getCardNumberLabelLocator());
        assertEquals("Срок действия", payFormPage.getExpiryLabelLocator());
        assertEquals("CVC", payFormPage.getCvcLabelLocator());
        assertEquals("Имя и фамилия на карте", payFormPage.getNameLabelLocator());
    }

    @Test
    @DisplayName("Логотипы платежных систем отображаются в форме")
    void testPaymentSystemLogosDisplayed() {
        assertTrue(payFormPage.isVisaLogoDisplayed());
        assertTrue(payFormPage.isMasterCardLogoDisplayed());
        assertTrue(payFormPage.isBelkartLogoDisplayed());
        assertTrue(payFormPage.isMaestroLogoDisplayed());
        assertTrue(payFormPage.isMirLogoDisplayed());
    }
}