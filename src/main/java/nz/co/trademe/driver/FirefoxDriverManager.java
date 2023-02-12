package nz.co.trademe.driver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager extends DriverManager{

    void createDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mkrishnan\\development\\TradeMeTestSuite\\driver\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
    }
}
