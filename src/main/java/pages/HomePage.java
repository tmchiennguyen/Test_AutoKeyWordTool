package pages;

import com.sun.javafx.scene.layout.region.Margins;
import net.sourceforge.htmlunit.corejs.javascript.ObjToIntMap;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static support.Helpers.*;

/**
 * Created by nancy.nguyen on 6/24/2015.
 */
public class HomePage {
    By btn_Google=By.xpath("/html[@class='js']/body[@class='front not-logged-in no-sidebars page-node front']/div[@id='header-wrap']/div[@class='container']/div[@id='header']/div[@class='region region-header']/div[@id='block-kt-search-search']/div[@class='content']/form[@id='kt-search-form']/div/div[@class='item-list']/ul[@id='search-tab']/li[@class='active first']/a[@class='active']");
    By btn_YouTube=By.xpath("/html[@class='js']/body[@class='front not-logged-in no-sidebars page-node front']/div[@id='header-wrap']/div[@class='container']/div[@id='header']/div[@class='region region-header']/div[@id='block-kt-search-search']/div[@class='content']/form[@id='kt-search-form']/div/div[@class='item-list']/ul[@id='search-tab']/li[2]/a");
    By btn_Bing=By.xpath("/html[@class='js']/body[@class='front not-logged-in no-sidebars page-node front']/div[@id='header-wrap']/div[@class='container']/div[@id='header']/div[@class='region region-header']/div[@id='block-kt-search-search']/div[@class='content']/form[@id='kt-search-form']/div/div[@class='item-list']/ul[@id='search-tab']/li[3]/a");
    By btn_AppStore=By.xpath("/html[@class='js']/body[@class='front not-logged-in no-sidebars page-node front']/div[@id='header-wrap']/div[@class='container']/div[@id='header']/div[@class='region region-header']/div[@id='block-kt-search-search']/div[@class='content']/form[@id='kt-search-form']/div/div[@class='item-list']/ul[@id='search-tab']/li[@class='last']/a");

    public boolean Load_HomePage(WebDriver driver){
        String title=driver.getTitle();
        if(title.indexOf("Keyword Tool") >= 0)return true;
        else return false;
    }

    public void Goto_GoogleSearch(WebDriver driver){
        find_element(driver, btn_Google).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public void Goto_YouTubeSearch(WebDriver driver){
        find_element(driver, btn_YouTube).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public void Goto_BingSearch(WebDriver driver){
        find_element(driver, btn_Bing).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public void Goto_AppStoreSearch(WebDriver driver){
        find_element(driver, btn_AppStore).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }







}
