package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class CSSSelectorAddRecordTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        //Chrome driver yolu
        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");

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
        driver.get("https://demoqa.com/webtables");

    }
    @Test(priority = 0)
    public void testPageTitleShown() {
        driver.get("https://demoqa.com/webtables");
        String pageTitle = driver.getTitle();
        System.out.println("Page Title is: " + pageTitle);
        Assert.assertEquals(pageTitle, "DEMOQA");
    }

    @Test(priority = 1)
    public void testButtonPage() {
        WebElement textCenter = driver.findElement(By.cssSelector("h1.text-center"));
        Assert.assertTrue(textCenter.isDisplayed());
        Assert.assertEquals(textCenter.getText(),"Web Tables");
    }

    @Test(priority = 2)
    public void testClickAddButton(){
        WebElement addButton = driver.findElement(By.cssSelector("button#addNewRecordButton"));
        wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
        WebElement regForm = driver.findElement(By.cssSelector("div#registration-form-modal"));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div#registration-form-modal"))));
        Assert.assertTrue(regForm.isDisplayed());
    }

    @Test(priority = 3)
    public void testAddRecord(){
        WebElement firstName = driver.findElement(By.cssSelector("input#firstName"));
        firstName.sendKeys("Ece");
        WebElement lastName = driver.findElement(By.cssSelector("input#lastName"));
        lastName.sendKeys("Tüzeltürk");
        WebElement email = driver.findElement(By.cssSelector("input#userEmail"));
        email.sendKeys("test@test.com");
        WebElement age = driver.findElement(By.cssSelector("input#age"));
        age.sendKeys("26");
        WebElement salary = driver.findElement(By.cssSelector("input#salary"));
        salary.sendKeys("100000");
        WebElement department = driver.findElement(By.cssSelector("input#department"));
        department.sendKeys("IT");
        WebElement submitButton=driver.findElement(By.cssSelector("button#submit"));
        submitButton.click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("h1[class='text-center']"))));

        String firstNameSaved= driver.findElement(By.cssSelector(".rt-tbody > .rt-tr-group:nth-of-type(4) .rt-td:first-of-type")).getText();
        Assert.assertEquals(firstNameSaved,"Ece");


    }
        @Test(priority = 3)
        public void testUpdateRecord(){
            WebElement editButton = driver.findElement(By.cssSelector("span[id='edit-record-4']"));
            editButton.click();
            WebElement fName = driver.findElement(By.cssSelector("input#firstName"));
            fName.clear();
            fName.sendKeys("Naz");
            WebElement submitBtn = driver.findElement(By.cssSelector("button#submit"));
            submitBtn.click();

            String firstName= driver.findElement(By.cssSelector(".rt-tbody > .rt-tr-group:nth-of-type(4) .rt-td:first-of-type")).getText();
            Assert.assertEquals(firstName,"Naz");
        }

    @AfterClass
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
}
