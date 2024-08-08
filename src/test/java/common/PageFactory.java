package common;


import pages.ElementsPage;
import pages.ButtonsPage;
import pages.WebTablesPage;

public class PageFactory {


    public static ElementsPage buildElementsPage() {
        return new ElementsPage("https://demoqa.com/elements");
    }

    public static ButtonsPage buildButtonsPage() {
        return new ButtonsPage("https://demoqa.com/buttons");
    }

    public static WebTablesPage buildWebTablesPage() {
        return new WebTablesPage("https://demoqa.com/webtables");
    }

}