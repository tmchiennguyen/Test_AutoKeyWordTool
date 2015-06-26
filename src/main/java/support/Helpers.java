package support;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.TableResult;

import java.util.concurrent.TimeUnit;

/**
 * Created by nancy.nguyen on 6/24/2015.
 */
public class Helpers {
    public static WebElement find_element(WebDriver driver, By locator) {
        return driver.findElement(locator);
    }

    public static boolean Exist_Element(WebDriver driver, By local){
        try{
            WebElement el=find_element(driver, local);
            return true;
        } catch(Exception ex){
            return false;
        }
    }
    public static boolean Click_ToSearch(WebDriver driver, By tbx, By btn, String KeySearch){
        find_element(driver, tbx).sendKeys(KeySearch);
        find_element(driver, btn).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        TableResult tableResult=new TableResult();
        System.out.print("CLICK TO SEARCH _ ");
        return tableResult.Load_TableResult(driver);
    }
    public static boolean Enter_ToSearch(WebDriver driver, By tbx, String KeySearch){
        WebElement el=find_element(driver, tbx);
        el.sendKeys(KeySearch);
        el.sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        TableResult tableResult=new TableResult();
        System.out.print("ENTER TO SEARCH _ ");
        return tableResult.Load_TableResult(driver);
    }
    public static boolean Can_SelectCbb(WebDriver driver, By local){
        Select ListLocation=new Select(find_element(driver, local));
        ListLocation.selectByIndex(5);
        String first=find_element(driver, local).getText();
        ListLocation.selectByIndex(20);
        String last=find_element(driver, local).getText();

        if(first.equals(last)) return false;
        else return true;
    }
    public static boolean Can_SendKeyCbb(WebDriver driver, By localCbb, By localTxt){
        String first=find_element(driver, localCbb).getText();
        find_element(driver, localCbb).click();
        find_element(driver, localTxt).sendKeys("d");
        Select laguage=new Select(find_element(driver, localCbb));
        laguage.selectByIndex(1);
        String last=find_element(driver, localCbb).getText();

        if(first.equals(last)) return false;
        else return true;
    }
}
