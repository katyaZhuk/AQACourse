package senla.addressbook.pageObjects;

import static senla.addressbook.locators.Locators.*;

public class Tests extends Methods {

    public static void login(String username, String password) {
        enterValueToField(EMAIL_LOCATOR, username);
        enterValueToField(PASSWORD_LOCATOR, password);
        clickOnElement(SIGNIN_BUTTON_LOCATOR);
    }

    public static void addAddress(String name, String lastName,
                               String address, String city, String zipCode) {
        clickOnElement(ADDRESSES_LINK_LOCATOR);
        clickOnElement(NEW_ADDRESS_LINK_LOCATOR);
        enterValueToField(FIRST_NAME_LOCATOR, name);
        enterValueToField(LAST_NAME_LOCATOR, lastName);
        enterValueToField(STREET_LOCATOR, address);
        enterValueToField(CITY_LOCATOR, city);
        enterValueToField(ZIP_CODE_LOCATOR, zipCode);
        clickOnElement(CREATE_ADDRESS_BUTTON_LOCATOR);
        clickOnElement(LIST_LINK_LOKATOR);
    }
    public static void editAddress(String address, String city, String zipCode) {
        clickOnElement(ADDRESSES_LINK_LOCATOR);
        clickOnElement(EDIT_LINK_LOCATOR);
        clearField(STREET_LOCATOR);
        enterValueToField(STREET_LOCATOR, address);
        clearField(CITY_LOCATOR);
        enterValueToField(CITY_LOCATOR, city);
        clearField(ZIP_CODE_LOCATOR);
        enterValueToField(ZIP_CODE_LOCATOR, zipCode);
        clickOnElement(UPDATE_ADDRESS_BUTTON_LOCATOR);
    }

    public static void deleteAddress() {
        clickOnElement(ADDRESSES_LINK_LOCATOR);
        clickOnElement(DESTROY_LINK_LOCATOR);
        acceptAlert();
    }

    public static void logout() {
        clickOnElement(SIGNOUT_LINK_LOCATOR);
    }

}
