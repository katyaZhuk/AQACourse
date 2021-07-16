package senla.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static senla.addressbook.AddAddressTest.addAddress;
import static senla.addressbook.LoginTest.login;

public class DeleteAddressTest {
  public static void main(String[] args) throws InterruptedException {

    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts()
            .implicitlyWait(Duration.ofSeconds(5000));

    login(driver);
//  addAddress(driver);
    driver.findElement(By.xpath("//a[contains(text(), 'Addresses')]"))
            .click();
    driver.findElement(By.xpath("//a[contains(text(), 'Destroy')]"))
            .click();
    driver.switchTo().alert().accept();

    Thread.sleep(1000);

    driver.close();
    driver.quit();

  }
}
