package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class XPathClickButtonTest
{
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        //Chrome driver yolu
        System.setProperty("webdriver.chrome.driver", "src/main/java/drivers/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://demoqa.com/elements");

    }

    @Test(priority = 0)
    public void testPageTitleShown() {
        driver.get("https://demoqa.com/elements");
        String pageTitle = driver.getTitle();
        System.out.println("Page Title is: " + pageTitle);
        Assert.assertEquals(pageTitle, "DEMOQA");
    }

    @Test(priority = 1)
    public void testButtonPage() {
        WebElement menuButton = driver.findElement(By.xpath("//*[@id=\"item-4\"]"));
        menuButton.click();
        WebElement textCenter = driver.findElement(By.xpath("//h1[@class=\"text-center\"]"));
        Assert.assertTrue(textCenter.isDisplayed());
        Assert.assertEquals(textCenter.getText(),"Buttons");
    }

    @Test(priority = 2)
    public void testClickMeButtonClick() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement clickMeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=\"Click Me\"]")));
        clickMeButton.click();
        WebElement result = driver.findElement(By.xpath("//p[@id=\"dynamicClickMessage\"]"));
        Assert.assertTrue(result.isDisplayed());
        Assert.assertEquals(result.getText(),"You have done a dynamic click");
    }

    @AfterClass
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
}
