package pageObjects;

import org.openqa.selenium.By;
import utils.Log;

public class SignInPage extends BasePage {

    private final static By EMAIL_FIELD = By.id("session_email");
    private final static By PASSWORD_FIELD = By.id("session_password");
    private final static By SIGNIN_BUTTON = By.cssSelector(".btn.btn-primary");

    public void openPage(String url) {
        Log.info("Open addressbook page");
        getURL(url);
    }

    public void login(String username, String password) {
        Log.info("Enter credentials for login");
        enterValueToField(EMAIL_FIELD, username);
        enterValueToField(PASSWORD_FIELD, password);
        Log.info("Click on sign in button");
        clickOnElement(SIGNIN_BUTTON);
    }

    public void finishWork() {
        quitDriver();
    }

}
