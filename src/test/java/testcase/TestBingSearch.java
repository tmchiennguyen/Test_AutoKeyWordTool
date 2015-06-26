package testcase;

import Utils.SetupTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BingSearch;
import pages.HomePage;
import pages.TableResult;

/**
 * Created by nancy.nguyen on 6/26/2015.
 */
public class TestBingSearch extends SetupTest {
    @Test
    public void test_SearchB(){
        HomePage homePage=new HomePage();
        Assert.assertEquals(homePage.Load_HomePage(driver), true);
        homePage.Goto_BingSearch(driver);

        BingSearch bingSearch=new BingSearch();
        Assert.assertEquals(bingSearch.Load_SearchBing(driver),true);
//        Assert.assertEquals(googleSearch.Click_SearchGoogle(driver), true);
        Assert.assertEquals(bingSearch.Enter_SearchBing(driver), true);

        TableResult tableResult=new TableResult();
        Assert.assertEquals(tableResult.Load_TableResult(driver), true);
        tableResult.Sort_ascend(driver, 1);;
        tableResult.Get_SelectedResult(driver);
    }
}
