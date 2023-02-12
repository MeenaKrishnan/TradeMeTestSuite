package nz.co.trademe.driver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriverManager extends DriverManager{


    void createDriver() {

        System.setProperty("webdriver.edge.driver", "C:\\Users\\Mkrishnan\\development\\TradeMeTestSuite\\driver\\msedgedriver.exe");
        EdgeOptions options = new EdgeOptions();
        driver = new EdgeDriver(options);


    }
}
