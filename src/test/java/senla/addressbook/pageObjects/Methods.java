package senla.addressbook.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Driver;

import java.util.List;

import static senla.addressbook.locators.Locators.*;

public class Methods {

    static WebDriver driver = Driver.getChromeDriver();

    public void openPage(String url) {
        driver.get(url);
    }

    @Step("Click on element")
    protected static void clickOnElement(By selector) {
        driver.findElement(selector).click();
    }

    @Step("Enter value to the field")
    protected static void enterValueToField(By selector, String username) {
        driver.findElement(selector)
                .sendKeys(username);
    }

    @Step("Clear the field")
    protected static void clearField(By selector) {
        driver.findElement(selector).clear();
    }

    @Step("Accept alert")
    protected static void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void finishWork() {
        driver.quit();
    }

    @Step("Get page title")
    protected String getPageTitle() {
        return driver.getTitle();
    }

    @Step("Find add addresses")
    protected List<WebElement> findAllAddresses() {
        return driver.findElements(ALL_ADDRESSES_LOCATOR);
    }

    @Step("Get city element")
    protected String getCityElement() {
        return driver.findElement(EDITED_CITY_LOCATOR).getText();
    }

}
