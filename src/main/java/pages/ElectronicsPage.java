package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElectronicsPage extends BasePage {
    private static final Logger logger = Logger.getLogger("Electronics page logger");

    @FindBy(xpath = "(//*[contains(@class,'catalog-navigation-list__aside-title')])[1]")
    private WebElement mobilePhoneLink;
    @FindBy(xpath = "(//*[contains(@class,'catalog-navigation-list__dropdown-title') and text()=' Смартфоны '])[1]")
    private WebElement smartphoneLink;

    public ElectronicsPage() {
        super();
    }

    public ElectronicsPage clickOnMobilePhoneLink() {
        mobilePhoneLink.click();
        logger.debug("Clicked successfully on the button : " + mobilePhoneLink.getText());
        return this;
    }

    public SmartphonePage clickOnSmartphoneLink() {
        smartphoneLink.click();
        logger.debug("Clicked successfully on the button : " + smartphoneLink.getText());
        return new SmartphonePage();
    }
}