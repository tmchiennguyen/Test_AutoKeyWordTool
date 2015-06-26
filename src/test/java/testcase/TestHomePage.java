package testcase;

import Utils.SetupTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

/**
 * Created by nancy.nguyen on 6/24/2015.
 */
public class TestHomePage extends SetupTest {
    @Test
    public void test_HomePage(){
        HomePage homePage=new HomePage();
        Assert.assertEquals(homePage.Load_HomePage(driver), true);
    }
}
