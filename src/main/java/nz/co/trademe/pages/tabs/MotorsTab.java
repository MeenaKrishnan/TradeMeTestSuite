package nz.co.trademe.pages.tabs;

import nz.co.trademe.utils.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class MotorsTab extends BaseTab{
    private WebDriver driver;
    private BaseTab baseTab;


    public MotorsTab(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

   @FindAll({
            @FindBy(xpath=("//div[@class='o-tabs__nav']/a"))
    })
            private List<WebElement> allTabs;

    public String getTitle(){
        return this.getTitle();
    }

    public String getCurrentSelectedTab(){
       WaitHelper.waitForPageToBeLoaded(driver);
        for (WebElement i:allTabs ) {
            if(i.getAttribute("class").contains("selected")){
                return i.getText();
            }
            }
        throw new RuntimeException("None of the tabs are selected");
    }

    public void clickTab(String tabName){
     WaitHelper.waitForPageToBeLoaded(driver);
      baseTab.clickTab(allTabs,tabName);
    }

}
