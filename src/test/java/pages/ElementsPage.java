package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;

public class ElementsPage extends BasePage{

    public SelenideElement menuButton = $("div.show:nth-of-type(1) li#item-4");


    public ElementsPage(String pageUrl) {
        super(pageUrl);
    }

    public String getPageTitle() {
        return title();
    }
}
