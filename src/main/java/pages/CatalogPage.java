package pages;

import elements.CustomButton;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;

public class CatalogPage extends BasePage {
    private static final Logger logger = Logger.getLogger("Catalog page logger");

    @FindBy(xpath = "//span[contains(@class,'catalog-navigation-classifier__item-title') and text() ='Электроника']")
    private CustomButton electronicsButton;

    public CatalogPage() {
        super();
    }

    public ElectronicsPage clickOnElectronicsPageButton() {
        electronicsButton.click();
        logger.debug("Clicked successfully on the electronics button");
        return new ElectronicsPage();
    }
}