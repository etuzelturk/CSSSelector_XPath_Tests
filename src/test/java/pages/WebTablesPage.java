package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class WebTablesPage extends BasePage{

    public SelenideElement textCenter = $("h1.text-center");
    public SelenideElement addButton = $("button#addNewRecordButton");
    public SelenideElement regForm = $("div#registration-form-modal");
    public SelenideElement firstName = $("input#firstName");
    public SelenideElement lastName = $("input#lastName");
    public SelenideElement email = $("input#userEmail");
    public SelenideElement age = $("input#age");
    public SelenideElement salary = $("input#salary");
    public SelenideElement department = $("input#department");
    public SelenideElement submitButton = $("button#submit");
    public SelenideElement firstNameSaved = $(".rt-tbody > .rt-tr-group:nth-of-type(4) .rt-td:first-of-type");
    public SelenideElement editButton = $("span#edit-record-4");

    public WebTablesPage(String pageUrl) {
        super(pageUrl);
    }
}
