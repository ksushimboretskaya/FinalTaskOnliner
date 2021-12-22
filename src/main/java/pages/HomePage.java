package pages;

import elements.CustomButton;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    private static final Logger logger = Logger.getLogger("Home page logger");

    @FindBy(xpath = "//span[contains(@class,'b-main-navigation__text')and text() = 'Каталог']")
    private CustomButton catalogButton;

    @FindBy(xpath = "//span[contains(@class,'b-main-navigation__text')and text() = 'Услуги']")
    private CustomButton servicesButton;

    @FindBy(className = "onliner_logo")
    private CustomButton logo;

    public HomePage() {
        super();
    }

    @Step("Click on the catalogs page button")
    public CatalogPage clickOnCatalogsPageButton() {
        catalogButton.click();
        logger.debug("Clicked successfully on the catalog page button");
        return new CatalogPage();
    }

    @Step("Click on the services page button")
    public ServicesPage clickOnTheServicesPageButton() {
        servicesButton.click();
        logger.debug("Clicked successfully on the services page button");
        return new ServicesPage();
    }

    @Step("Click on the logotype")
    public HomePage clickOnTheLogotype() {
        logo.click();
        logger.debug("Clicked successfully on the logo");
        return new HomePage();
    }

    @Step("Get page url")
    public String getPageUrl() {
        logger.debug("Successfully retrieved current URL");
        return driver.getCurrentUrl();
    }
}