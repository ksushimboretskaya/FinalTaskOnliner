package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    private static final Logger logger = Logger.getLogger("Home page logger");

    @FindBy(xpath = "//span[contains(@class,'b-main-navigation__text')and text() = 'Каталог']")
    private WebElement catalogLink;

    public HomePage() {
        super();
    }

    public CatalogPage clickOnCatalogsPageLink() {
        catalogLink.click();
        logger.debug("Clicked successfully on the button : " + catalogLink.getText());
        return new CatalogPage();
    }
}