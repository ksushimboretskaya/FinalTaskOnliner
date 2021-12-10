package pages;

import elements.CustomButton;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;

public class ElectronicsPage extends BasePage {
    private static final Logger logger = Logger.getLogger("Electronics page logger");

    @FindBy(xpath = "(//*[contains(@class,'catalog-navigation-list__aside-title')])[1]")
    private CustomButton mobilePhoneButton;
    @FindBy(xpath = "(//*[contains(@class,'catalog-navigation-list__dropdown-title') and text()=' Смартфоны '])[1]")
    private CustomButton smartphoneButton;

    public ElectronicsPage() {
        super();
    }

    public ElectronicsPage clickOnMobilePhoneButton() {
        mobilePhoneButton.click();
        logger.debug("Clicked successfully on the mobile phone button");
        return this;
    }

    public SmartphonePage clickOnSmartphoneButton() {
        smartphoneButton.click();
        logger.debug("Clicked successfully on the smartphone page button");
        return new SmartphonePage();
    }
}