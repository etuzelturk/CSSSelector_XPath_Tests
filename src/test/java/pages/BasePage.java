package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import utils.PropertyManager;

public class BasePage
{
    protected String pageUrl;
    PropertyManager propertyManager = new PropertyManager();

    public BasePage(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public void open() {
        Selenide.open(pageUrl);
    }

    public String getUrl(){
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }
}
