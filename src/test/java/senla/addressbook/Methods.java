package senla.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Methods {

    WebDriver driver;

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(5000));
    }

    public void openPage(String url) {
        driver.get(url);
    }

    protected void clickOnElement(By selector) {
        driver.findElement(selector).click();
    }

    protected void enterValueToField(By selector, String username) {
        driver.findElement(selector)
                .sendKeys(username);
    }

    protected void clearField(By selector) {
        driver.findElement(selector).clear();
    }

    protected void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void finishWork() {
        driver.quit();
    }

}
