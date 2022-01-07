package pages;

import elements.CustomCheckBox;
import elements.CustomTextElement;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;

public class ServicesPage extends BasePage {

    private static final Logger logger = Logger.getLogger("Services page logger");

    @FindBy(xpath = "(//*[contains(@class,'i-checkbox service-form__checkbox service-form__checkbox_base')])[1]")
    private CustomCheckBox regionCheckBox;

    @FindBy(xpath = "(//*[contains(@class,'button-style button-style_default button-style_small service-tags__button ng-binding')])[1]")
    private CustomTextElement location;

    public ServicesPage() {
        super();
    }

    @Step("Choose the region 'Минск'")
    public ServicesPage chooseRegionFilter() {
        regionCheckBox.click();
        logger.info("Clicked successfully on the checkbox with text 'Минск'");
        return new ServicesPage();
    }

    @Step("Check region filter")
    public String checkChosenRegionFilter() {
        logger.debug("Successfully retrieved region");
        return location.getText();
    }
}