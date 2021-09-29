package senla.addressbook.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import pageObjects.AddressesPage;
import pageObjects.EditingAddressPage;
import pageObjects.HomePage;
import pageObjects.SignInPage;

import java.io.IOException;

import static helpers.AddAddressHelper.*;
import static helpers.EditAddressHelper.*;
import static helpers.SignInHelper.*;
import static pageObjects.BasePage.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestAddressBook {

    SignInPage signInPage = new SignInPage();
    HomePage homePage = new HomePage();
    AddressesPage addressesPage = new AddressesPage();
    EditingAddressPage editingAddressPage = new EditingAddressPage();

    @BeforeAll
    public void setUp() throws IOException {
        signInPage.openPage(getURL());

        String pageTitle = getPageTitle();
        Assertions.assertEquals(getLoginPageTitle(), pageTitle,
                "Wrong page or page title is not correct");
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Login to addressbook site test")
    @Feature("Login feature")
    @Test
    @Order(1)
    public void testLogin() throws IOException {

        signInPage.login(getEmail(), getPassword());

        String pageTitle = getPageTitle();
        Assertions.assertEquals(getHomePageTitle(), pageTitle,
                "Wrong or not registered credentials");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Add address to addressbook test")
    @Feature("Add address feature")
    @Issue("213456")
    @Link("http://qwerty.com/1")
    @Test
    @Order(3)
    public void testAddAddress() throws IOException {

        homePage.clickAddressLink();

        int amountAddressesBefore = addressesPage.findAddressesAmount();

        addressesPage.addAddress(getName(), getLastName(),
                getAddress(), getCity(), getZipCode());

        int amountAddressesAfter = addressesPage.findAddressesAmount();

        Assertions.assertEquals(1, amountAddressesAfter - amountAddressesBefore,
                "Something went wrong");
    }

    @Severity(SeverityLevel.MINOR)
    @Description("Edit address test")
    @Feature("Edit address feature")
    @Disabled
    @Test
    public void testEditAddress() throws IOException {

        homePage.clickAddressLink();
        addressesPage.addAddress(getName(), getLastName(),
                getAddress(), getCity(), getZipCode());

        editingAddressPage.editAddress(getNewAddress(), getNewCity(), getNewZipCode());

        String editedCity = editingAddressPage.getCityElement();

        Assertions.assertEquals(getNewCity(), editedCity, "City is not edited");
    }

    @Severity(SeverityLevel.MINOR)
    @Description("Delete address from addressbook test")
    @Feature("Delete address feature")
    @Issue("987654")
    @Link("http://qwerty.com/2")
    @Test
    @Order(2)
    public void testDeleteAddress() {

        homePage.clickAddressLink();

        int amountAddressesBefore = addressesPage.findAddressesAmount();

        addressesPage.deleteAddress();

        int amountAddressesAfter = addressesPage.findAddressesAmount();

        Assertions.assertEquals(1, amountAddressesBefore - amountAddressesAfter,
                "Something went wrong");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Logout test")
    @Feature("Logouts feature")
    @Owner("Senla")
    @Test
    @Order(4)
    public void testLogout() throws IOException {
        homePage.logout();

        String pageTitle = getPageTitle();
        Assertions.assertEquals(getLoginPageTitle(), pageTitle,
                "Something went wrong");
    }

    @AfterAll
    public void tearDown() {
        signInPage.finishWork();
    }
}
