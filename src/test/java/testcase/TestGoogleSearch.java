package testcase;

import Utils.SetupTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleSearch;
import pages.HomePage;
import pages.TableResult;

import java.util.concurrent.TimeUnit;

/**
 * Created by nancy.nguyen on 6/26/2015.
 */
public class TestGoogleSearch extends SetupTest {
    @Test
    public void test_LoadPage(){
        HomePage homePage=new HomePage();
        Assert.assertEquals(homePage.Load_HomePage(driver), true);
        homePage.Goto_GoogleSearch(driver);

        GoogleSearch googleSearch=new GoogleSearch();
        Assert.assertEquals(googleSearch.Load_SearchGoogle(driver),true);
    }

    @Test
    public void test_Search(){
        HomePage homePage=new HomePage();
        Assert.assertEquals(homePage.Load_HomePage(driver), true);
        homePage.Goto_GoogleSearch(driver);

        GoogleSearch googleSearch=new GoogleSearch();
        TableResult tableResult=new TableResult();

        Assert.assertEquals(googleSearch.Enter_SearchGoogle(driver), true);
        Assert.assertEquals(tableResult.Load_TableResult(driver), true);

        googleSearch.Delete_SendKeys(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Assert.assertEquals(googleSearch.Click_SearchGoogle(driver), true);
        Assert.assertEquals(tableResult.Load_TableResult(driver), true);
    }

    @Test
    public void test_SortResult(){
        HomePage homePage=new HomePage();
        Assert.assertEquals(homePage.Load_HomePage(driver), true);
        homePage.Goto_GoogleSearch(driver);

        GoogleSearch googleSearch=new GoogleSearch();
        TableResult tableResult=new TableResult();

        Assert.assertEquals(googleSearch.Enter_SearchGoogle(driver), true);
        Assert.assertEquals(tableResult.Load_TableResult(driver), true);

        tableResult.Sort_ascend(driver, 1);
        tableResult.Sort_descend(driver, 1);
    }

    @Test void test_GetSelectedItems(){
        HomePage homePage=new HomePage();
        Assert.assertEquals(homePage.Load_HomePage(driver), true);
        homePage.Goto_GoogleSearch(driver);

        GoogleSearch googleSearch=new GoogleSearch();
//        googleSearch.Select_Combobox(driver);
        Assert.assertEquals(googleSearch.Enter_SearchGoogle(driver), true);

        TableResult tableResult=new TableResult();
        Assert.assertEquals(tableResult.Load_TableResult(driver), true);

        // --- Print results
        tableResult.Get_SelectedResult(driver);
    }

}
