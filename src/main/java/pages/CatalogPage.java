package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CatalogPage extends BasePage {
    private static final Logger logger = Logger.getLogger("Catalog page logger");

    @FindBy(xpath = "//span[contains(@class,'catalog-navigation-classifier__item-title') and text() ='Электроника']")
    private WebElement electronicsLink;

    public CatalogPage() {
        super();
    }

    public ElectronicsPage clickOnElectronicsPageLink() {
        electronicsLink.click();
        logger.debug("Clicked successfully on the button : " + electronicsLink.getText());
        return new ElectronicsPage();
    }
}