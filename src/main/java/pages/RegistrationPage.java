package pages;

import elements.CustomButton;
import elements.CustomTextElement;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
    private static final Logger logger = Logger.getLogger("Registration page logger");

    @FindBy(xpath = "//button[@type='submit']")
    private CustomButton submitRegistrationButton;

    @FindBy(xpath = "//*[contains(@class,'growl-content')]")
    private CustomTextElement message;

    public RegistrationPage() {
        super();
    }

    @Step("Registration without login and password")
    public RegistrationPage registrationWithoutData() {
        submitRegistrationButton.click();
        logger.debug("Clicked successfully om the submit registration button");
        return new RegistrationPage();
    }

    @Step("Verify registration message")
    public boolean verifyErrorMessage() {
        return message.isDisplayed();
    }
}