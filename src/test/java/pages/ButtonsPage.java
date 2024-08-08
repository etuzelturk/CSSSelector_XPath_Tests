package pages;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class ButtonsPage extends BasePage{

    public SelenideElement clickMeButton = $("div.col-12.mt-4.col-md-6:nth-child(2) > div:nth-child(2) > div.mt-4:nth-child(4) > button");
    public SelenideElement resultMessage = $("p#dynamicClickMessage");
    public SelenideElement textCenter = $("h1.text-center");

    public ButtonsPage(String pageUrl) {
        super(pageUrl);
    }
}
