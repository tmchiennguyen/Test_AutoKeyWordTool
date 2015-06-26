package testcase;

import Utils.SetupTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

/**
 * Created by nancy.nguyen on 6/26/2015.
 */
public class TestAppStoreSearch extends SetupTest {
    @Test
    public void test_LoadPage(){
        HomePage homePage=new HomePage();
        Assert.assertEquals(homePage.Load_HomePage(driver), true);
        homePage.Goto_AppStoreSearch(driver);
    }
}
