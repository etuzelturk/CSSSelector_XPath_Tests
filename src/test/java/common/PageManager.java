package common;

import drivers.DriverFactory;
import pages.ButtonsPage;
import pages.ElementsPage;
import pages.WebTablesPage;

public class PageManager {

    public ElementsPage elementsPage;
    public ButtonsPage buttonsPage;
    public WebTablesPage webTablesPage;

    public PageManager() {

        DriverFactory.initDriver();

        elementsPage = PageFactory.buildElementsPage();
        buttonsPage = PageFactory.buildButtonsPage();
        webTablesPage = PageFactory.buildWebTablesPage();

    }


}