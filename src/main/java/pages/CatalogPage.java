package pages;

import elements.CustomButton;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;

public class CatalogPage extends BasePage {

    private static final Logger logger = Logger.getLogger("Catalog page logger");

    @FindBy(xpath = "//span[contains(@class,'catalog-navigation-classifier__item-title') and text() ='Электроника']")
    private CustomButton electronicsButton;

    public CatalogPage() {
        super();
    }

    @Step("Click on the electronics page button")
    public ElectronicsPage clickOnElectronicsPageButton() {
        electronicsButton.click();
        logger.debug("Clicked successfully on the electronics button");
        return new ElectronicsPage();
    }
}