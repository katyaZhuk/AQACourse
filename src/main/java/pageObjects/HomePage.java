package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.Log;

public class HomePage extends BasePage {

    private final By ADDRESSES_LINK = By.xpath("//a[contains(text(), 'Addresses')]");
    private final By SIGNOUT_LINK = By.linkText("Sign out");


    @Step("Click on addresses link")
    public void clickAddressLink() {
        Log.info("Click on address link");
        clickOnElement(ADDRESSES_LINK);
    }

    @Step("Log out")
    public void logout() {
        Log.info("Logout");
        clickOnElement(SIGNOUT_LINK);
    }

}
