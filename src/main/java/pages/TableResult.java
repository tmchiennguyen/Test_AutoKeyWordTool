package pages;

import javafx.collections.transformation.SortedList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.lang.reflect.Array;
import java.util.*;

import static support.Helpers.Exist_Element;
import static support.Helpers.find_element;

/**
 * Created by nancy.nguyen on 6/25/2015.
 */
public class TableResult {
    By lb_NumberResults=By.xpath("/html/body/div[3]/div/div/div/div/div/div[2]/div/div/div/div/div/div/h1/strong");
    By btn_CoppyAll=By.xpath("/html/body/div[3]/div/div/div/div/div/div[2]/div/div/div/div/div/div/div[1]/button[1]");
    By btn_Coppy=By.xpath("/html/body/div[3]/div/div/div/div/div/div[2]/div/div/div/div/div/div/div[1]/button[2]");

    // Result Table
    By cbx_All=By.xpath("//*[@id='results-suggestions']/div/div/table/thead/tr/th[1]/div/input");
    By cbx_item=By.xpath("//*[@id='results-suggestions']/div/div/table/tbody/tr[1]/td[1]/input");

    By btn_Terms=By.xpath("//*[@id='results-suggestions']/div/div/table/thead/tr/th[2]");
    By btn_KeyWords=By.xpath("//*[@id='results-suggestions']/div/div/table/thead/tr/th[3]");
    By SearchVolume=By.xpath("/html[@class='js']/body[@class='html not-front not-logged-in no-sidebars page-search rtl']/div[@id='main']/div[@class='container']/div[@id='content']/div[@class='region region-content']/div[@id='block-system-main']/div[@class='content']/div[@id='results-wrapper']/div[@class='container-fluid']/div[@class='row']/div[@class='tab-content']/div[@id='results-suggestions']/div[@class='row results']/div[@class='col-xs-12 col-md-12']/table[@class='table search-results tablesorter tablesorter-default']/thead/tr[@class='tablesorter-headerRow']/th[@class='col-volume tablesorter-header tablesorter-headerUnSorted']/div[@class='tablesorter-header-inner']/label");
    By CPC=By.xpath("/html[@class='js']/body[@class='html not-front not-logged-in no-sidebars page-search rtl']/div[@id='main']/div[@class='container']/div[@id='content']/div[@class='region region-content']/div[@id='block-system-main']/div[@class='content']/div[@id='results-wrapper']/div[@class='container-fluid']/div[@class='row']/div[@class='tab-content']/div[@id='results-suggestions']/div[@class='row results']/div[@class='col-xs-12 col-md-12']/table[@class='table search-results tablesorter tablesorter-default']/thead/tr[@class='tablesorter-headerRow']/th[@class='col-cpc tablesorter-header tablesorter-headerUnSorted']/div[@class='tablesorter-header-inner']/label");
    By Competition=By.xpath("/html[@class='js']/body[@class='html not-front not-logged-in no-sidebars page-search rtl']/div[@id='main']/div[@class='container']/div[@id='content']/div[@class='region region-content']/div[@id='block-system-main']/div[@class='content']/div[@id='results-wrapper']/div[@class='container-fluid']/div[@class='row']/div[@class='tab-content']/div[@id='results-suggestions']/div[@class='row results']/div[@class='col-xs-12 col-md-12']/table[@class='table search-results tablesorter tablesorter-default']/thead/tr[@class='tablesorter-headerRow']/th[@class='col-cmp tablesorter-header tablesorter-headerUnSorted']/div[@class='tablesorter-header-inner']/label");

    By btn_BackToTop=By.xpath("/html[@class='js']/body[@class='html not-front not-logged-in no-sidebars page-search rtl']/div[@id='main']/div[@class='container']/div[@id='content']/div[@class='region region-content']/div[@id='block-system-main']/div[@class='content']/div[@id='results-top']/p/a[@class='top active']");

    public boolean Load_TableResult(WebDriver driver){
        if(Exist_Element(driver, btn_Terms)){
            System.out.println("LOAD SUCCESSFULL TABLE RESULT !!!");
            return true;
        }
        else {
            System.out.println("LOAD FAILED TABLE RESULT");
            return false;
        }
    }

    public void Select_Items(WebDriver driver, int[] list){
        int TotalResult= Integer.parseInt(find_element(driver, lb_NumberResults).getText());
        for(int i=0; i< list.length && TotalResult > 0 ; i++){
            if(list[i] < TotalResult){
                By x=By.xpath("//*[@id='results-suggestions']/div/div/table/tbody/tr["+ list[i] +"]/td["+ 1 +"]/input");
                find_element(driver, x).click();
            }
            else {
                System.out.println("POSITION "+ list[i] +" DONT EXIST !!!");
            }
        }
    }

    public void Get_SelectedResult(WebDriver driver){
        boolean flag=true;
        int[] list={1, 4, 6, 7, 14, 12, 20};
        int TotalResult= Integer.parseInt(find_element(driver, lb_NumberResults).getText());
        if(TotalResult > 0 ){Arrays.sort(list);
            Select_Items(driver, list);
            HashMap<String, String> ListResult=new HashMap<String, String>();
            for(int i=1; i<=list[list.length-1] && i<= TotalResult; i++){
                String term="";
                String keyword="";

                By x=By.xpath("//*[@id='results-suggestions']/div/div/table/tbody/tr["+ i +"]/td[1]/input");
                if(find_element(driver, x).isSelected()) {
                    By term_xpath=By.xpath("//*[@id='results-suggestions']/div/div/table/tbody/tr["+i+"]/td[2]");
                    By keyword_xpath=By.xpath("//*[@id='results-suggestions']/div/div/table/tbody/tr["+i+"]/td[3]/span");

                    term=find_element(driver, term_xpath).getText();
                    keyword=find_element(driver, keyword_xpath).getText();

                    if (keyword.indexOf(term) < 0) flag = false;
                    ListResult.put(keyword, term);
                }
            }
            if(flag){
                List<Map.Entry> entryList=new ArrayList<Map.Entry>(ListResult.entrySet());
                for(Map.Entry t: entryList) {
                    System.out.println(t);
                }
            } else {
                System.out.println("SEARCH NOT CORRECTLY !!!");
            }
        }
    }

    public void Get_AllResult(WebDriver driver) {
        boolean flag = true;
        int TotalResult = Integer.parseInt(find_element(driver, lb_NumberResults).getText());

        HashMap<String, String> ListResult = new HashMap<String, String>();
        for (int i = 1; i <= TotalResult; i++) {
            String term = "";
            String keyword = "";
            By term_xpath = By.xpath("//*[@id='results-suggestions']/div/div/table/tbody/tr[" + i + "]/td[2]");
            By keyword_xpath = By.xpath("//*[@id='results-suggestions']/div/div/table/tbody/tr[" + i + "]/td[3]/span");

            term = find_element(driver, term_xpath).getText();
            keyword = find_element(driver, keyword_xpath).getText();

            if (keyword.indexOf(term) < 0) flag = false;
            ListResult.put(keyword, term);
        }
         if(flag){
            List<Map.Entry> entryList=new ArrayList<Map.Entry>(ListResult.entrySet());
            for(Map.Entry t: entryList) {
                System.out.println(t);
            }
        } else {
            System.out.println("SEARCH NOT CORRECTLY !!!");
        }
    }

    // Kind = 0 >>> Sort by Terms
    // Kind = 1 >>> Sort by KeyWords
    public void Sort_ascend(WebDriver driver, int kind){
        int TotalResult = Integer.parseInt(find_element(driver, lb_NumberResults).getText());
        if(TotalResult >0){
            if(kind==0){
                if(find_element(driver, btn_Terms).getAttribute("aria-sort").equals("none")){
                    find_element(driver, btn_Terms).click();
                    find_element(driver, btn_Terms).click();
                }
                else if( find_element(driver, btn_Terms).getAttribute("aria-sort").equals("descending")){
                    find_element(driver, btn_Terms).click();
                }
            } else if(kind==1 ){
                if(find_element(driver, btn_KeyWords).getAttribute("aria-sort").equals("none")){
                    find_element(driver, btn_KeyWords).click();
                    find_element(driver, btn_KeyWords).click();
                }
                else if( find_element(driver, btn_KeyWords).getAttribute("aria-sort").equals("descending")){
                    find_element(driver, btn_KeyWords).click();
                }
            }
        }
    }
    public void Sort_descend(WebDriver driver, int kind){
        int TotalResult = Integer.parseInt(find_element(driver, lb_NumberResults).getText());
        if(TotalResult >0){
            if(kind==0){
                if(find_element(driver, btn_Terms).getAttribute("aria-sort").equals("none")){
                    find_element(driver, btn_Terms).click();
                }
                else if( find_element(driver, btn_Terms).getAttribute("aria-sort").equals("ascending")){
                    find_element(driver, btn_Terms).click();
                }
            }
            else if(kind==1) {
                if (find_element(driver, btn_KeyWords).getAttribute("aria-sort").equals("none")) {
                    find_element(driver, btn_KeyWords).click();
                } else if (find_element(driver, btn_KeyWords).getAttribute("aria-sort").equals("ascending")) {
                    find_element(driver, btn_KeyWords).click();
                }
            }
        }
    }
}
