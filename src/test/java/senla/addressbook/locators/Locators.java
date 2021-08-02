package senla.addressbook.locators;

import org.openqa.selenium.By;

public class Locators {

    public final static By EMAIL_LOCATOR = By.id("session_email");
    public final static By PASSWORD_LOCATOR = By.id("session_password");
    public final static By SIGNIN_BUTTON_LOCATOR = By.cssSelector(".btn.btn-primary");

    public final static By ADDRESSES_LINK_LOCATOR = By.xpath("//a[contains(text(), 'Addresses')]");
    public final static By NEW_ADDRESS_LINK_LOCATOR = By.xpath("//a[contains(text(), 'New Address')]");
    public final static By FIRST_NAME_LOCATOR = By.id("address_first_name");
    public final static By LAST_NAME_LOCATOR = By.id("address_last_name");
    public final static By STREET_LOCATOR = By.id("address_street_address");
    public final static By CITY_LOCATOR = By.id("address_city");
    public final static By ZIP_CODE_LOCATOR = By.id("address_zip_code");
    public final static By CREATE_ADDRESS_BUTTON_LOCATOR = By.name("commit");

    public final static By EDIT_LINK_LOCATOR = By.xpath("//a[contains(text(), 'Edit')]");
    public final static By UPDATE_ADDRESS_BUTTON_LOCATOR = By.cssSelector("[value='Update Address']");

    public final static By DESTROY_LINK_LOCATOR = By.xpath("//a[contains(text(), 'Destroy')]");

    public final static By SIGNOUT_LINK_LOCATOR = By.linkText("Sign out");

    public final static By ALL_ADDRESSES_LOCATOR = By.cssSelector("tbody tr");

    public final static By LIST_LINK_LOCATOR = By.xpath("//a[contains(text(), 'List')]");

    public final static By EDITED_CITY_LOCATOR = By.cssSelector("span[data-test=\"city\"]");

}
