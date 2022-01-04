package pages;

import elements.CustomTextElement;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;

public class SmartphonePage extends BasePage {
    private static final Logger logger = Logger.getLogger("Smartphone page logger");

    @FindBy(xpath = "//*[contains(@class,'schema-header__title') and text()='Мобильные телефоны']")
    private CustomTextElement headerText;

    public SmartphonePage() {
        super();
    }

    @Step("Get smartphone page tittle")
    public String getPageHeaderText() {
        logger.debug("Successfully retrieved smartphone page title");
        return headerText.getText();
    }
}