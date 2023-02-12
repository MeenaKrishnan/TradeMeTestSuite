package nz.co.trademe.base;

import nz.co.trademe.driver.DriverManager;
import nz.co.trademe.driver.DriverManagerFactory;
import nz.co.trademe.driver.DriverType;
import nz.co.trademe.utils.TestConfig;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
    public WebDriver driver;
    DriverManager driverManager;

    @BeforeMethod
    public void setUp(){
        getLocalDriver(TestConfig.getEnvProperty("browser"));
        driver.manage().window().maximize();
        driver.navigate().to(TestConfig.getEnvProperty("url"));
    }

    public WebDriver getLocalDriver(String browserName){
        if (browserName.equalsIgnoreCase("Chrome")) {
            driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
            driver = driverManager.getDriver();
            }
        else if( browserName.equalsIgnoreCase("Firefox")){
            driverManager = DriverManagerFactory.getManager(DriverType.FIREFOX);
            driver = driverManager.getDriver();
        }
        else if( browserName.equalsIgnoreCase("Edge")){
            driverManager = DriverManagerFactory.getManager(DriverType.EDGE);
            driver = driverManager.getDriver();
        }
        return driver;
    }
    @AfterMethod
    public void tearDown(){
        driverManager.quitDriver();
    }

}
