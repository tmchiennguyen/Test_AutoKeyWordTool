package testcase;

import Utils.SetupTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleSearch;
import pages.HomePage;
import pages.TableResult;

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
        Assert.assertEquals(googleSearch.Enter_SearchGoogle(driver), true);

        TableResult tableResult=new TableResult();
        Assert.assertEquals(tableResult.Load_TableResult(driver), true);
    }
    @Test
    public void test_SortResult(){
        HomePage homePage=new HomePage();
        Assert.assertEquals(homePage.Load_HomePage(driver), true);
        homePage.Goto_GoogleSearch(driver);

        GoogleSearch googleSearch=new GoogleSearch();
        Assert.assertEquals(googleSearch.Enter_SearchGoogle(driver), true);

        TableResult tableResult=new TableResult();
        Assert.assertEquals(tableResult.Load_TableResult(driver), true);

        tableResult.Sort_ascend(driver, 1);
        tableResult.Sort_descend(driver, 1);
    }

    @Test void test_GetSelectedItems(){
        HomePage homePage=new HomePage();
        Assert.assertEquals(homePage.Load_HomePage(driver), true);
        homePage.Goto_GoogleSearch(driver);

        GoogleSearch googleSearch=new GoogleSearch();
        Assert.assertEquals(googleSearch.Enter_SearchGoogle(driver), true);

        TableResult tableResult=new TableResult();
        Assert.assertEquals(tableResult.Load_TableResult(driver), true);

        tableResult.Get_SelectedResult(driver);
    }

}
