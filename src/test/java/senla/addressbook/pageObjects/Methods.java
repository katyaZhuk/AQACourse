package senla.addressbook.pageObjects;

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

    protected static void clickOnElement(By selector) {
        driver.findElement(selector).click();
    }

    protected static void enterValueToField(By selector, String username) {
        driver.findElement(selector)
                .sendKeys(username);
    }

    protected static void clearField(By selector) {
        driver.findElement(selector).clear();
    }

    protected static void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void finishWork() {
        driver.quit();
    }

    protected String getPageTitle() {
        return driver.getTitle();
    }

    protected List<WebElement> findAllAddresses() {
        return driver.findElements(ALL_ADDRESSES_LOCATOR);
    }

    protected String getCityElement() {
        return driver.findElement(EDITED_CITY_LOCATOR).getText();
    }

}
