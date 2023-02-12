package nz.co.trademe.pages;

import nz.co.trademe.pages.tabs.BaseTab;
import nz.co.trademe.pages.tabs.MotorsTab;
import nz.co.trademe.utils.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;


public class HomePage extends BasePage{
    public WebDriver driver;
    private MotorsTab motorsTab;

    public HomePage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    @FindAll({
            @FindBy(xpath=("//ul[@class='tm-homepage-search-header__vertical-links-list']/li"))
    })
    public List<WebElement> allSearchMenuTabs;

    public List<WebElement> getAllSearchMenuTabs(){
        WaitHelper.waitForPageToBeLoaded(driver);
        return allSearchMenuTabs;
    }

    public void clickSearchMenu(String tabName){
         baseTab = new BaseTab(driver);
         WaitHelper.waitForPageToBeLoaded(driver);
         baseTab.clickTab(allSearchMenuTabs,tabName);
    }




}
