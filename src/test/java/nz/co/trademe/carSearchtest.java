package nz.co.trademe;

import nz.co.trademe.base.BaseClass;
import nz.co.trademe.pages.HomePage;
import nz.co.trademe.pages.tabs.Motors.CarSearchTab;
import nz.co.trademe.pages.tabs.MotorsTab;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class carSearchtest extends BaseClass {
    public HomePage homePage;
    public MotorsTab motorsTab;
    public CarSearchTab carSearchTab;

    @Test
    public void verifyNumberOfCarMakesAvailable(){
        homePage = new HomePage(driver);
        List<WebElement> tabs = homePage.getAllSearchMenuTabs();
        //Verify the number of Menu Tabs
        Assert.assertEquals(tabs.size(),6,"Menu Tabs not matching");
        homePage.clickSearchMenu("Motors");
        motorsTab = new MotorsTab(driver);
        //Verify if the Cars Tab is automatically selected
        Assert.assertEquals(motorsTab.getCurrentSelectedTab(),"Cars","Cars Tab is not selected");
        carSearchTab = new CarSearchTab(driver);
        //Verify the number of car makes available in the car drop down
        Assert.assertEquals(carSearchTab.getAllCarMakeDropDownOptions().size(),79,"Number of Car Makes available in the Make drop down is not Matching ");

    }

    @DataProvider(name = "provideCarMakeAndSearchResult")
    public Object [] [] carMakeSearchData ()
    {
        Object [] [] data = new Object [4] [2];

        data [0] [0] = "Ferrari";    data [0] [1] = "Showing 43 results";
        data [1] [0] = "BMW";      data [1] [1] = "Showing 3,514 results";
        data [2] [0] = "Mazda";      data [2] [1] = "Showing 5,922 results";
        data [3] [0] = "Honda";      data [3] [1] = "Showing 2,700 results";
        return data;
    }

    @Test(dataProvider = "provideCarMakeAndSearchResult")
    public void verifyCarSearchResults(String carMake,String result){
        homePage = new HomePage(driver);
        List<WebElement> tabs = homePage.getAllSearchMenuTabs();
        //Verify the number of Menu Tabs
        Assert.assertEquals(tabs.size(),6,"Menu Tabs not matching");
        homePage.clickSearchMenu("Motors");
        motorsTab = new MotorsTab(driver);
        //Verify if the Cars Tab is automatically selected
        Assert.assertEquals(motorsTab.getCurrentSelectedTab(),"Cars","Cars Tab is not selected");
        carSearchTab = new CarSearchTab(driver);
        //Verify the number of car makes available in the car drop down
        Assert.assertEquals(carSearchTab.getAllCarMakeDropDownOptions().size(),79,"Number of Car Makes available in the Make drop down is not Matching ");
        carSearchTab.selectMake(carMake);
        carSearchTab.clickSearchButton();
        //Verify the car search  results
        Assert.assertEquals(carSearchTab.getSearchResultCount(),result,"CarSearchByMake results does not match ");
    }

}
