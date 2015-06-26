package pages;

import org.openqa.selenium.*;

import static support.Helpers.*;

/**
 * Created by nancy.nguyen on 6/26/2015.
 */
public class BingSearch {
    String KeySearch="singer in vietnam";
    By tbx_KeyWord=By.xpath("/html/body/div[2]/div/div[2]/div/div/div/form/div/div[1]/div[1]/div/input");
    By btn_Search=By.xpath("/html/body/div[2]/div/div[2]/div/div/div/form/div/div[3]/button");

    public boolean Load_SearchBing(WebDriver driver){
        String title=driver.getTitle();
        if (title.indexOf("Bing") >= 0) return true;
        else return false;
    }
    public boolean Click_SearchBing(WebDriver driver){
        return Click_ToSearch(driver, tbx_KeyWord, btn_Search, KeySearch);
    }
    public boolean Enter_SearchBing(WebDriver driver){
        return Enter_ToSearch(driver, tbx_KeyWord, KeySearch);
    }
}
