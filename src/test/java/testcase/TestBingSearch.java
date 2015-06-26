package testcase;

import Utils.SetupTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BingSearch;
import pages.HomePage;
import pages.TableResult;

import java.util.concurrent.TimeUnit;


/**
 * Created by nancy.nguyen on 6/26/2015.
 */
public class TestBingSearch extends SetupTest {
    @Test
    public void test_LoadPage(){
        HomePage homePage=new HomePage();
        Assert.assertEquals(homePage.Load_HomePage(driver), true);
        homePage.Goto_BingSearch(driver);

        BingSearch bingSearch=new BingSearch();
        Assert.assertEquals(bingSearch.Load_SearchBing(driver),true);
    }

    @Test
    public void test_Search(){
        HomePage homePage=new HomePage();
        Assert.assertEquals(homePage.Load_HomePage(driver), true);
        homePage.Goto_BingSearch(driver);

        BingSearch bingSearch=new BingSearch();
        TableResult tableResult=new TableResult();

        Assert.assertEquals(bingSearch.Click_SearchBing(driver), true);
        Assert.assertEquals(tableResult.Load_TableResult(driver), true);

        bingSearch.Delete_SendKeys(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Assert.assertEquals(bingSearch.Enter_SearchBing(driver), true);
        Assert.assertEquals(tableResult.Load_TableResult(driver), true);
    }

    @Test
    public void test_SortResult(){
        HomePage homePage=new HomePage();
        Assert.assertEquals(homePage.Load_HomePage(driver), true);
        homePage.Goto_BingSearch(driver);

        BingSearch bingSearch=new BingSearch();
        TableResult tableResult=new TableResult();

        Assert.assertEquals(bingSearch.Enter_SearchBing(driver), true);
        Assert.assertEquals(tableResult.Load_TableResult(driver), true);

        tableResult.Sort_ascend(driver, 1);
        tableResult.Sort_descend(driver, 1);
    }

    @Test
    public void test_GetSelectItems(){
        HomePage homePage=new HomePage();
        Assert.assertEquals(homePage.Load_HomePage(driver), true);
        homePage.Goto_BingSearch(driver);

        BingSearch bingSearch=new BingSearch();
        TableResult tableResult=new TableResult();

        Assert.assertEquals(bingSearch.Enter_SearchBing(driver), true);
        Assert.assertEquals(tableResult.Load_TableResult(driver), true);

        tableResult.Get_SelectedResult(driver);
    }
}
