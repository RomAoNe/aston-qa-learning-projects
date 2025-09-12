package Lesson_10.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver webDriver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.webDriver = driver;
        this.wait = wait;
        this.actions = new Actions(driver);
    }
}
