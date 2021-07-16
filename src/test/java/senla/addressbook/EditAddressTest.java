package senla.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static senla.addressbook.AddAddressTest.addAddress;
import static senla.addressbook.LoginTest.login;

public class EditAddressTest {

  public static void main(String[] args) throws InterruptedException {

    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts()
            .implicitlyWait(Duration.ofSeconds(5000));

    login(driver);
//  addAddress(driver);
    driver.findElement(By.xpath("//a[contains(text(), 'Addresses')]"))
            .click();
    driver.findElement(By.xpath("//a[contains(text(), 'Edit')]"))
            .click();
    driver.findElement(By.id("address_state"))
            .click();
    driver.findElement(By.xpath("//option[contains(text(), 'Texas')]"))
            .click();
    driver.findElement(By.cssSelector("[value=\"Update Address\"]"))
            .click();

    Thread.sleep(1000);

    driver.close();
    driver.quit();
  }
}
