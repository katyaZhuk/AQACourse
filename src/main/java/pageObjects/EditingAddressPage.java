package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.Log;

public class EditingAddressPage extends BasePage {

    private final By STREET_FIELD = By.id("address_street_address");
    private final By CITY_FIELD = By.id("address_city");
    private final By ZIP_CODE_FIELD = By.id("address_zip_code");
    private final By EDIT_LINK = By.xpath("//a[contains(text(), 'Edit')]");
    private final By UPDATE_ADDRESS_BUTTON = By.cssSelector("[value='Update Address']");
    private final By EDITED_CITY_FIELD = By.cssSelector("span[data-test=\"city\"]");

    public void editAddress(String address, String city, String zipCode) {

        Log.info("Edit address");
        clickOnElement(EDIT_LINK);
        clearField(STREET_FIELD);
        enterValueToField(STREET_FIELD, address);
        clearField(CITY_FIELD);
        enterValueToField(CITY_FIELD, city);
        clearField(ZIP_CODE_FIELD);
        enterValueToField(ZIP_CODE_FIELD, zipCode);
        clickOnElement(UPDATE_ADDRESS_BUTTON);
    }

    @Step("Get city element")
    public String getCityElement() {
        return driver.findElement(EDITED_CITY_FIELD).getText();
    }

}
