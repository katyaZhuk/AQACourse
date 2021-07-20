package senla.addressbook;

import org.openqa.selenium.By;

public class Tests extends Methods {

    public void testLogin(String username, String password) {
        enterValueToField(By.id("session_email"), username);
        enterValueToField(By.id("session_password"), password);
        clickOnElement(By.cssSelector(".btn.btn-primary"));
    }

    public void testAddAddress(String name, String lastName,
                               String address, String city, String zipCode) {
        clickOnElement(By.xpath("//a[contains(text(), 'Addresses')]"));
        clickOnElement(By.xpath("//a[contains(text(), 'New Address')]"));
        enterValueToField(By.id("address_first_name"), name);
        enterValueToField(By.id("address_last_name"), lastName);
        enterValueToField(By.id("address_street_address"), address);
        enterValueToField(By.id("address_city"), city);
        enterValueToField(By.id("address_zip_code"), zipCode);
        clickOnElement(By.name("commit"));
    }

    public void testEditAddress(String address, String city, String zipCode) {
        clickOnElement(By.xpath("//a[contains(text(), 'Addresses')]"));
        clickOnElement(By.xpath("//a[contains(text(), 'Edit')]"));
        clearField(By.id("address_street_address"));
        enterValueToField(By.id("address_street_address"), address);
        clearField(By.id("address_city"));
        enterValueToField(By.id("address_city"), city);
        clearField(By.id("address_zip_code"));
        enterValueToField(By.id("address_zip_code"), zipCode);
        clickOnElement(By.cssSelector("[value='Update Address']"));
    }

    public void testDeleteAddress() {
        clickOnElement(By.xpath("//a[contains(text(), 'Addresses')]"));
        clickOnElement(By.xpath("//a[contains(text(), 'Destroy')]"));
        acceptAlert();
    }

    public void testLogout() {
        clickOnElement(By.linkText("Sign out"));
    }

}
