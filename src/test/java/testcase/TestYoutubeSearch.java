package testcase;

import Utils.SetupTest;
import javafx.scene.control.Tab;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TableResult;
import pages.YoutubeSearch;

import java.util.concurrent.TimeUnit;

/**
 * Created by nancy.nguyen on 6/26/2015.
 */
public class TestYoutubeSearch extends SetupTest {
    @Test
    public void test_LoadPage(){
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

    @Test
    public void test_Search(){
        HomePage homePage=new HomePage();
        Assert.assertEquals(homePage.Load_HomePage(driver), true);
        homePage.Goto_YouTubeSearch(driver);

        YoutubeSearch youtubeSearch=new YoutubeSearch();
        TableResult tableResult=new TableResult();

        Assert.assertEquals(youtubeSearch.Enter_SearchYouTube(driver), true);
        Assert.assertEquals(tableResult.Load_TableResult(driver), true);

        youtubeSearch.Delete_SendKeys(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Assert.assertEquals(youtubeSearch.Click_SearchYouTube(driver), true);
        Assert.assertEquals(tableResult.Load_TableResult(driver), true);
    }

    @Test
    public void test_SortResults(){
        HomePage homePage=new HomePage();
        Assert.assertEquals(homePage.Load_HomePage(driver), true);
        homePage.Goto_YouTubeSearch(driver);

        YoutubeSearch youtubeSearch=new YoutubeSearch();
        TableResult tableResult=new TableResult();

        Assert.assertEquals(youtubeSearch.Enter_SearchYouTube(driver), true);
        Assert.assertEquals(tableResult.Load_TableResult(driver), true);

        tableResult.Sort_ascend(driver, 1);
        tableResult.Sort_descend(driver, 1);
    }

    @Test
    public void test_GetSelectedItems(){
        HomePage homePage=new HomePage();
        Assert.assertEquals(homePage.Load_HomePage(driver), true);
        homePage.Goto_YouTubeSearch(driver);

        YoutubeSearch youtubeSearch=new YoutubeSearch();
        TableResult tableResult=new TableResult();

        Assert.assertEquals(youtubeSearch.Enter_SearchYouTube(driver), true);
        Assert.assertEquals(tableResult.Load_TableResult(driver), true);

        tableResult.Get_SelectedResult(driver);
    }
}
