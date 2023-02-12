package nz.co.trademe.pages;

import nz.co.trademe.pages.tabs.BaseTab;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class BasePage {
    private WebDriver driver;
    protected BaseTab baseTab;

    public BasePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
}
