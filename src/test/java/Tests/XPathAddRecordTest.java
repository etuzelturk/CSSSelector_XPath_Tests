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

public class XPathAddRecordTest {
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
        WebElement textCenter = driver.findElement(By.xpath("//h1[@class=\"text-center\"]"));
        Assert.assertTrue(textCenter.isDisplayed());
        Assert.assertEquals(textCenter.getText(),"Web Tables");
    }

    @Test(priority = 2)
    public void testClickAddButton(){
        WebElement addButton = driver.findElement(By.xpath("//button[@id=\"addNewRecordButton\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
        WebElement regForm = driver.findElement(By.xpath("//div[@id=\"registration-form-modal\"]"));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id=\"registration-form-modal\"]"))));
        Assert.assertTrue(regForm.isDisplayed());
    }

    @Test(priority = 3)
    public void testAddRecord(){
        WebElement firstName = driver.findElement(By.xpath("//input[@id=\"firstName\"]"));
        firstName.sendKeys("Ece");
        WebElement lastName = driver.findElement(By.xpath("//input[@id=\"lastName\"]"));
        lastName.sendKeys("Tüzeltürk");
        WebElement email = driver.findElement(By.xpath("//input[@id=\"userEmail\"]"));
        email.sendKeys("test@test.com");
        WebElement age = driver.findElement(By.xpath("//input[@id=\"age\"]"));
        age.sendKeys("26");
        WebElement salary = driver.findElement(By.xpath("//input[@id=\"salary\"]"));
        salary.sendKeys("100000");
        WebElement department = driver.findElement(By.xpath("//input[@id=\"department\"]"));
        department.sendKeys("IT");
        WebElement submitButton=driver.findElement(By.xpath("//button[@id=\"submit\"]"));
        submitButton.click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[@class=\"text-center\"]"))));

        String firstNameSaved= driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[1]")).getText();
        Assert.assertEquals(firstNameSaved,"Ece");


    }
    @Test(priority = 3)
    public void testUpdateRecord(){
        WebElement editButton = driver.findElement(By.xpath("//span[@id=\"edit-record-4\"]"));
        editButton.click();
        WebElement fName = driver.findElement(By.xpath("//input[@id=\"firstName\"]"));
        fName.clear();
        fName.sendKeys("Naz");
        WebElement submitBtn = driver.findElement(By.xpath("//button[@id=\"submit\"]"));
        submitBtn.click();

        String firstName= driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[1]")).getText();
        Assert.assertEquals(firstName,"Naz");
    }

    @AfterClass
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
}
