package senla.addressbook.tests;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import senla.addressbook.pageObjects.Methods;
import senla.addressbook.pageObjects.Tests;
import utils.Log;

import java.util.List;

import static senla.addressbook.locators.Locators.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestAddressBook extends Methods {

    @BeforeAll
    public void setUp() {
        Log.info("Open addressbook page");
        openPage("http://a.testaddressbook.com/sign_in");

        Log.info("Check opened page is correct");
        String pageTitle = getPageTitle();
        Assertions.assertEquals("Address Book - Sign In", pageTitle,
                "Wrong page or page title is not correct");
    }

    @Test
    @Order(1)
    public void testLogin() {
        Log.info("Enter credentials for login");
        Tests.login("tester115@qa.com", "test");

        Log.info("Check if login is successful");
        String pageTitle = getPageTitle();
        Assertions.assertEquals("Address Book", pageTitle,
                "Wrong or not registered credentials");
    }

    @Test
    @Order(3)
    public void testAddAddress() {
        clickOnElement(ADDRESSES_LINK_LOCATOR);
        List<WebElement> beforeAddressesList = findAllAddresses();
        int amountAddressesBefore = beforeAddressesList.size();
        Log.info("Add new address");
        Tests.addAddress("Katya", "Zhuk",
                "Main Street, 1", "Vitebsk", "111111");

        Log.info("Check if new address is added");
        List<WebElement> afterAddressesList = findAllAddresses();
        int amountAddressesAfter = afterAddressesList.size();

        Assertions.assertTrue(amountAddressesAfter - amountAddressesBefore == 1,
                "Something went wrong");
    }

    @Ignore
    public void testEditAddress() {
        Tests.addAddress("Katya", "Zhuk",
                "Main Street, 1", "Vitebsk", "111111");

        Log.info("Edit address");
        Tests.editAddress("Second St. 101", "Minsk", "222222");

        Log.info("Check if address is changed");
        String editedCity = getCityElement();

        Assertions.assertEquals("Minsk", editedCity, "City is not edited");
    }

    @Test
    @Order(2)
    public void testDeleteAddress() {
        clickOnElement(ADDRESSES_LINK_LOCATOR);
        List<WebElement> beforeAddressesList = findAllAddresses();
        int amountAddressesBefore = beforeAddressesList.size();
        Log.info("Delete any address");
        Tests.deleteAddress();

        Log.info("Check if address is deleted");
        List<WebElement> afterAddressesList = findAllAddresses();
        int amountAddressesAfter = afterAddressesList.size();

        Assertions.assertTrue(amountAddressesBefore - amountAddressesAfter == 1,
                "Something went wrong");
    }

    @Test
    @Order(4)
    public void testLogout() {
        Log.info("Logout");
        Tests.logout();

        Log.info("Check if logout is successful");
        String pageTitle = getPageTitle();
        Assertions.assertEquals("Address Book - Sign In", pageTitle,
                "Something went wrong");
    }

    @AfterAll
    public void tearDown() {
        finishWork();
    }
}
