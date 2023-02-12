package nz.co.trademe.pages.tabs;

import nz.co.trademe.utils.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BaseTab {

    private WebDriver driver;

    public BaseTab(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css="h3[class='tm-search-header-result-count__heading ng-star-inserted']")
    public WebElement searchResultCount;

    public void clickTab(List<WebElement> allTabs, String tabName) {
        int clicked = 0;
        WaitHelper.waitForPageToBeLoaded(driver);
        for (WebElement i : allTabs) {
            if (i.getText().equalsIgnoreCase(tabName)) {

                i.click();
                clicked = ++clicked;
                break;
            }
        }
        if (clicked == 0) {
            throw new RuntimeException(tabName +" could not be clicked ");
        }
    }

    public List<String> getAllItemsInDropDownList(WebElement allSelectItems){
        WaitHelper.waitForPageToBeLoaded(driver);
        List allItemsInSelect = new ArrayList();
        Select s = new Select(allSelectItems);
        List <WebElement> allItems = s.getOptions();
        int size = allItems.size();
        for(int i =0; i<size ; i++){
            String options = allItems.get(i).getText();
            allItemsInSelect.add(options);
        }
        return allItemsInSelect;
        }

    public void selectDropDownItem(WebElement allDropDownItems,String item) {
        Select s = new Select(allDropDownItems);
        s.selectByValue(item);
    }
    public String getSearchResultCount(){
        WaitHelper.waitForElementToBeVisible(driver,searchResultCount);
        return searchResultCount.getText();
    }

}
