package testcase;

import Utils.SetupTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TableResult;
import pages.YoutubeSearch;

/**
 * Created by nancy.nguyen on 6/26/2015.
 */
public class TestYoutubeSearch extends SetupTest {
    @Test
    public void test_SearchYT(){
        HomePage homePage=new HomePage();
        Assert.assertEquals(homePage.Load_HomePage(driver), true);
        homePage.Goto_YouTubeSearch(driver);

        YoutubeSearch youtubeSearch=new YoutubeSearch();
        Assert.assertEquals(youtubeSearch.Load_SearchYouTube(driver),true);
//        Assert.assertEquals(googleSearch.Click_SearchGoogle(driver), true);
        Assert.assertEquals(youtubeSearch.Enter_SearchYouTube(driver), true);

        TableResult tableResult=new TableResult();
        tableResult.Sort_ascend(driver, 1);
        tableResult.Get_SelectedResult(driver);
    }
}
