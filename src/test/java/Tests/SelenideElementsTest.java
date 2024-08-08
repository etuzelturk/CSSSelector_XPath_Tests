package Tests;


import org.testng.annotations.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.title;
import static org.testng.AssertJUnit.assertEquals;
public class SelenideElementsTest extends SelenideBaseTest
{
    @BeforeMethod
    public void before(){
        pageManager.elementsPage.open();
    }

    @Test(priority = 0)
    public void testPageTitleShown() {
        String actualPageTitle = title();
        String expectedPageTitle = "DEMOQA";
        assertEquals(actualPageTitle, expectedPageTitle);
    }

    @Test(priority = 1)
    public void testButtonPage() {
        pageManager.elementsPage.menuButton.click();
        pageManager.buttonsPage.textCenter.shouldBe(visible).shouldHave(text("Buttons"));
    }
}
