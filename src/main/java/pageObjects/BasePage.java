package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Driver;

public class BasePage {

    static WebDriver driver = Driver.getChromeDriver();

    @Step("Open maximized window")
    public static void getURL(String url) {
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Step("Finish work")
    public static void quitDriver() {
        driver.quit();
    }

    @Step("Click on element")
    public static void clickOnElement(By selector) {
        driver.findElement(selector).click();
    }

    @Step("Enter value to the field")
    public static void enterValueToField(By selector, String username) {
        driver.findElement(selector)
                .sendKeys(username);
    }

    @Step("Clear the field")
    public static void clearField(By selector) {
        driver.findElement(selector).clear();
    }

    @Step("Accept alert")
    public static void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    @Step("Get page title")
    public static String getPageTitle() {
        return driver.getTitle();
    }

}
