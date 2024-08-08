package Tests;
import com.codeborne.selenide.Selenide;
import drivers.DriverFactory;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import common.PageManager;

import static drivers.DriverFactory.maximize;

public class SelenideBaseTest
{
    protected PageManager pageManager;
    protected SoftAssert softAssert;
    @BeforeClass
    public void setUp() {
        pageManager = new PageManager();
        softAssert = new SoftAssert();
    }

    @BeforeMethod
    public void openDriver() {
        Selenide.open();
        maximize();
    }

    @AfterMethod
    public void clearCookies() {
        DriverFactory.clearCookies();
    }

    @AfterClass
    public void tearDown() {
        DriverFactory.close();
    }
}
