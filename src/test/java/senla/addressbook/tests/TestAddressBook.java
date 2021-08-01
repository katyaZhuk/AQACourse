package senla.addressbook.tests;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import senla.addressbook.pageObjects.Methods;
import senla.addressbook.pageObjects.Tests;
import utils.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static senla.addressbook.locators.Locators.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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

    @Ignore
    public void testLogin() {
        Log.info("Enter credentials for login");
        Tests.login("tester115@qa.com", "test");

        Log.info("Check if login is successful");
        String pageTitle = getPageTitle();
        Assertions.assertEquals("Address Book", pageTitle,
                "Wrong or not registered credentials");
    }

    @Test
    public void testAddAddress() {
        Log.info("Enter credentials for login");
        Tests.login("tester115@qa.com", "test");

        clickOnElement(ADDRESSES_LINK_LOCATOR);
        List<WebElement> beforeAddresses = findAllAddresses();
        int amountBefore = beforeAddresses.size();
        Log.info("Add new address");
        Tests.addAddress("Katya", "Zhuk",
                "Main Street, 1", "Vitebsk", "111111");

        Log.info("Check if new address is added");
        List<WebElement> afterAddresses = findAllAddresses();
        int amountAfter = afterAddresses.size();

        Assertions.assertTrue(amountAfter - amountBefore == 1);
    }

    @Test
    public void testEditAddress() {
        Log.info("Enter credentials for login");
        Tests.login("tester115@qa.com", "test");

        Tests.addAddress("Katya", "Zhuk",
                "Main Street, 1", "Vitebsk", "111111");

        Log.info("Edit address");
        Tests.editAddress("Second St. 101","Minsk","222222");

        Log.info("Check if address is changed");
        String editedCity = getCityElement();

        Assertions.assertEquals("Minsk", editedCity);

    }

//        tests.deleteAddress();
//        tests.logout();
//
//        tests.finishWork();
//}

    @AfterAll
    public void tearDown() {
        finishWork();
    }
}
