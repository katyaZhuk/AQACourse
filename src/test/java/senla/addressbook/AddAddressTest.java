package senla.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static senla.addressbook.LoginTest.login;

public class AddAddressTest {
  public static void main(String[] args) throws InterruptedException {
    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts()
            .implicitlyWait(Duration.ofSeconds(5000));

    login(driver);
    addAddress(driver);

    Thread.sleep(1000);

    driver.close();
    driver.quit();

  }

  public static void addAddress(WebDriver driver) {
    driver.findElement(By.xpath("//a[contains(text(), 'Addresses')]"))
            .click();
    driver.findElement(By.xpath("//a[contains(text(), 'New Address')]"))
            .click();
    driver.findElement(By.id("address_first_name"))
            .sendKeys("Katya");
    driver.findElement(By.id("address_last_name"))
            .sendKeys("Zhuk");
    driver.findElement(By.id("address_street_address"))
            .sendKeys("Main Street, 1");
    driver.findElement(By.id("address_city"))
            .sendKeys("Vitebsk");
    driver.findElement(By.id("address_zip_code"))
            .sendKeys("111111");
    driver.findElement(By.name("commit"))
            .click();

  }
}
