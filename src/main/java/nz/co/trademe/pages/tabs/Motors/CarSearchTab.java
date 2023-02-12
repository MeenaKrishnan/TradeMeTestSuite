package nz.co.trademe.pages.tabs.Motors;

import nz.co.trademe.pages.tabs.BaseTab;
import nz.co.trademe.utils.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class CarSearchTab extends BaseTab {

    private WebDriver driver;
    private BaseTab baseTab;

    public CarSearchTab(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//select[@name='selectedMake']")
    public WebElement carMakeDropDownList;

    @FindBy(css="button[type='submit']")
    public WebElement searchButton;

    public List<String> getAllCarMakeDropDownOptions(){
        WaitHelper.waitForPageToBeLoaded(driver);
       baseTab = new BaseTab(driver);
       return baseTab.getAllItemsInDropDownList(carMakeDropDownList);
    }
    public void selectMake(String makeOption){
        baseTab.selectDropDownItem(carMakeDropDownList,makeOption);

    }
    public void clickSearchButton(){
        WaitHelper.waitForElementToBeClickable(driver,searchButton);
        searchButton.click();
    }




}
