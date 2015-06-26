package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static support.Helpers.*;

/**
 * Created by nancy.nguyen on 6/25/2015.
 */
public class YoutubeSearch {
    String KeySearch="singer in vietnam";
    By tbx_KeyWord=By.xpath("/html/body/div[2]/div/div[2]/div/div/div/form/div/div[1]/div[1]/div/input");
    By btn_Search=By.xpath("/html/body/div[2]/div/div[2]/div/div/div/form/div/div[3]/button");

    public boolean Load_SearchYouTube(WebDriver driver){
        String title=driver.getTitle();
        if (title.indexOf("YouTube") >= 0) return true;
        else return false;
    }
    public boolean Click_SearchYouTube(WebDriver driver){
        return Click_ToSearch(driver, tbx_KeyWord, btn_Search, KeySearch);
    }
    public boolean Enter_SearchYouTube(WebDriver driver){
        return Enter_ToSearch(driver, tbx_KeyWord, KeySearch);
    }
}
