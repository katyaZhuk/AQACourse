package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Log;

import java.util.List;

public class AddressesPage extends BasePage {

    private final By ALL_ADDRESSES_LIST = By.cssSelector("tbody tr");
    private final By NEW_ADDRESS_LINK = By.xpath("//a[contains(text(), 'New Address')]");
    private final By FIRST_NAME_FIELD = By.id("address_first_name");
    private final By LAST_NAME_FIELD = By.id("address_last_name");
    private final By STREET_FIELD = By.id("address_street_address");
    private final By CITY_FIELD = By.id("address_city");
    private final By ZIP_CODE_FIELD = By.id("address_zip_code");
    private final By CREATE_ADDRESS_BUTTON = By.name("commit");
    private final By LIST_LINK = By.xpath("//a[contains(text(), 'List')]");
    private final By DESTROY_LINK = By.xpath("//a[contains(text(), 'Destroy')]");


    @Step("Find number of addresses in the book")
    public int findAddressesAmount() {
        List<WebElement> addressesList = driver.findElements(ALL_ADDRESSES_LIST);
        return addressesList.size();
    }

    public void addAddress(String name, String lastName,
                           String address, String city, String zipCode) {

        Log.info("Add new address");
        clickOnElement(NEW_ADDRESS_LINK);
        enterValueToField(FIRST_NAME_FIELD, name);
        enterValueToField(LAST_NAME_FIELD, lastName);
        enterValueToField(STREET_FIELD, address);
        enterValueToField(CITY_FIELD, city);
        enterValueToField(ZIP_CODE_FIELD, zipCode);
        clickOnElement(CREATE_ADDRESS_BUTTON);
        clickOnElement(LIST_LINK);

    }

    public void deleteAddress() {
        Log.info("Delete any address");
        clickOnElement(DESTROY_LINK);
        acceptAlert();
    }

}
