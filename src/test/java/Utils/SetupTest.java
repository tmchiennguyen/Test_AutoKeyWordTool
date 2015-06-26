package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;
/**
 * Created by nancy.nguyen on 6/24/2015.
 */
public class SetupTest {
    public static WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get("http://keywordtool.io/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.quit();
    }
}
