package Tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class SelenideButtonsTest extends SelenideBaseTest{

    @BeforeMethod
    public void before(){
        pageManager.buttonsPage.open();
    }

    @Test
    public void testClickMeButtonClick() {
        System.out.printf("geturl = " + pageManager.buttonsPage.getUrl());
        pageManager.buttonsPage.clickMeButton.click();
        pageManager.buttonsPage.resultMessage.shouldBe(visible).shouldHave(text("You have done a dynamic click"));
    }

}
