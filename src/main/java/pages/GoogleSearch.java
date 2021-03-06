package pages;

import org.eclipse.jetty.util.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static support.Helpers.*;

/**
 * Created by nancy.nguyen on 6/24/2015.
 */
public class GoogleSearch {
    String KeySearch="singer in vietnam";
    By tbx_KeyWord=By.xpath("/html/body/div[2]/div/div[2]/div/div/div/form/div/div[1]/div[1]/div/input");
    By btn_Search=By.xpath("/html/body/div[2]/div/div[2]/div/div/div/form/div/div[3]/button");
    By cbb_Location=By.id("select2-edit-domain-container");
    By cbb_items=By.id("edit-domain");
    private Logger Log=Logger.getLogger(Log.class.getName());

    public boolean Load_SearchGoogle(WebDriver driver){
        String title=driver.getTitle();
        if (title.indexOf("Google") >= 0) return true;
         else return false;
    }
    public boolean Click_SearchGoogle(WebDriver driver){
            return Click_ToSearch(driver, tbx_KeyWord, btn_Search, KeySearch);
        }

    public boolean Enter_SearchGoogle(WebDriver driver){
        return Enter_ToSearch(driver, tbx_KeyWord, KeySearch);
    }

    public void Delete_SendKeys(WebDriver driver){
        WebElement el=find_element(driver, tbx_KeyWord);
        el.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        el.sendKeys(Keys.DELETE);
    }

    public void Select_Combobox(WebDriver driver){
        find_element(driver, cbb_Location).click();
        Select select=new Select(find_element(driver, cbb_items));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        select.selectByIndex(10);
    }
//    public void SelectLocation(WebDriver driver){
//        find_element(driver, cbb_Local).click();
//        Select list=new Select(find_element(driver, cbb_Local));
//        list.selectByIndex(5);
//        return Can_SelectCbb(driver, cbb_Local);
//    }
//    public boolean SendKeyLocation(WebDriver driver){
//        return Can_SendKeyCbb(driver,cbb_Local,tbx_Local);
//    }
}
