package pages;

import elements.CustomCheckBox;
import elements.CustomTextElement;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;

public class ServicesPage extends BasePage {

    private static final Logger logger = Logger.getLogger("Services page logger");

    @FindBy(xpath = "(//*[contains(@class,'i-checkbox service-form__checkbox service-form__checkbox_base')])[1]")
    private CustomCheckBox minskRegionCheckBox;

    @FindBy(xpath = "(//*[contains(@class,'button-style button-style_default button-style_small service-tags__button ng-binding')])[1]")
    private CustomTextElement regionFilter;

    public ServicesPage() {
        super();
    }

    @Step("Choose the region")
    public ServicesPage chooseMinskAsRegionFilter() {
        minskRegionCheckBox.click();
        logger.info("Clicked successfully on the checkbox with text 'Минск'");
        return new ServicesPage();
    }

    @Step("Check region filter")
    public String checkChosenRegionFilter() {
        logger.debug("Successfully retrieved region");
        return regionFilter.getText();
    }
}