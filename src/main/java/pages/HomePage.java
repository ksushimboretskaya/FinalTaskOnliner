package pages;

import elements.CustomButton;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    private static final Logger logger = Logger.getLogger("Home page logger");

    @FindBy(xpath = "//span[contains(@class,'b-main-navigation__text')and text() = 'Каталог']")
    private CustomButton catalogLink;

    public HomePage() {
        super();
    }

    public CatalogPage clickOnCatalogsPageLink() {
        catalogLink.click();
        logger.debug("Clicked successfully on the catalog page button");
        return new CatalogPage();
    }
}