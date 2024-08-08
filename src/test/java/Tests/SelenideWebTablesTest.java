package Tests;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.title;
import static org.testng.AssertJUnit.assertEquals;

public class SelenideWebTablesTest extends SelenideBaseTest{

    @BeforeMethod
    public void before() {
        pageManager.webTablesPage.open();
    }

    @Test(priority = 0)
    public void testPageTitleShown() {
        assertEquals(title(), "DEMOQA");
    }

    @Test(priority = 1)
    public void testButtonPage() {
        pageManager.webTablesPage.textCenter.shouldBe(visible).shouldHave(text("Web Tables"));
    }

    @Test(priority = 2)
    public void testClickAddButton() {
        pageManager.webTablesPage.addButton.click();
        pageManager.webTablesPage.regForm.shouldBe(visible);
    }

    @Test(priority = 3)
    public void testAddRecordUpdate() {

        pageManager.webTablesPage.addButton.shouldBe(visible).click();
        pageManager.webTablesPage.regForm.shouldBe(visible);

        pageManager.webTablesPage.firstName.setValue("Ece");
        pageManager.webTablesPage.lastName.setValue("Tüzeltürk");
        pageManager.webTablesPage.email.setValue("test@test.com");
        pageManager.webTablesPage.age.setValue("26");
        pageManager.webTablesPage.salary.setValue("100000");
        pageManager.webTablesPage.department.setValue("IT");
        Selenide.sleep(1000);
        pageManager.webTablesPage.submitButton.click();
        Selenide.sleep(1000);
        pageManager.webTablesPage.firstNameSaved.shouldHave(text("Ece"), Duration.ofSeconds(10));
        System.out.printf("first name saved 1 = " +  pageManager.webTablesPage.firstNameSaved.getText());

        pageManager.webTablesPage.firstNameSaved.shouldBe(visible);
        pageManager.webTablesPage.editButton.shouldBe(visible, Duration.ofSeconds(10)).click();
        pageManager.webTablesPage.regForm.shouldBe(visible);

        pageManager.webTablesPage.firstName.clear();
        pageManager.webTablesPage.firstName.setValue("Naz");
        pageManager.webTablesPage.submitButton.click();

        pageManager.webTablesPage.firstNameSaved.shouldHave(text("Naz"));
        System.out.printf("first name saved 2 = " + pageManager.webTablesPage.firstNameSaved.getText());
    }
}
