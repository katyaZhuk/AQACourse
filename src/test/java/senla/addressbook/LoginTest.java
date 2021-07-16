package senla.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginTest {

  public static void main(String[] args) throws InterruptedException {

    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts()
            .implicitlyWait(Duration.ofSeconds(5));

    login(driver);

    Thread.sleep(1000);

    driver.close();
    driver.quit();
  }

  public static void login(WebDriver driver) {
    driver.get("http://a.testaddressbook.com/sign_in");
    driver.findElement(By.id("session_email"))
            .sendKeys("tester115@qa.com");
    driver.findElement(By.id("session_password"))
            .sendKeys("test");
    driver.findElement(By.xpath("//input[@class='btn btn-primary']"))
            .click();

  }
}
