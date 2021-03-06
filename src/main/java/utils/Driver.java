package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    static WebDriver driver;

    public static WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts()
                .implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver getFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts()
                .implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

}
