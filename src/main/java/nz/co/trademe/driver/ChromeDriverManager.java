package nz.co.trademe.driver;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class ChromeDriverManager extends DriverManager{



    void createDriver() {

        System.setProperty("webdriver.edge.driver", "C:\\Users\\Mkrishnan\\development\\TradeMeTestSuite\\driver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);


    }
}
