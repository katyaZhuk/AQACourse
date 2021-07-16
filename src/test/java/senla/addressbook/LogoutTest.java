package senla.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static senla.addressbook.LoginTest.login;

public class LogoutTest {
  public static void main(String[] args) throws InterruptedException {

    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts()
            .implicitlyWait(Duration.ofSeconds(5000));

    login(driver);
    driver.findElement(By.linkText("Sign out"))
            .click();

    Thread.sleep(1000);

    driver.close();
    driver.quit();

  }
}
