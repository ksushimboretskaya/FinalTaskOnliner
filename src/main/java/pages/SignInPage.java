package pages;

import elements.CustomButton;
import elements.CustomTextElement;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    private static final Logger logger = Logger.getLogger("SignIn page logger");

    @FindBy(xpath = "(//*[contains(@class,'auth-input auth-input_primary auth-input_base auth-form__input auth-form__input_width_full')])[1]")
    private CustomTextElement loginField;

    @FindBy(xpath = "(//*[contains(@class,'auth-input auth-input_primary auth-input_base auth-form__input auth-form__input_width_full')])[2]")
    private CustomTextElement passwordField;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    private CustomButton submitSignInButton;

    @FindBy(xpath = "(//*[contains(@class,'auth-form__description auth-form__description_error auth-form__description_base auth-form__description_extended-other')])[1]")
    private CustomTextElement signInMessage;

    @FindBy(xpath = "//*[contains(@class,'auth-form__link auth-form__link_primary auth-form__link_small')]")
    private CustomButton registrationButton;

    public SignInPage() {
        super();
    }

    @Step("Input login and password")
    public SignInPage signInWithLoginAndPassword(String login, String password) {
        loginField.sendKeys(login);
        logger.debug("Successfully input login ["+login+"]");
        passwordField.sendKeys(password);
        logger.debug("Successfully input password ["+password+"]");
        submitSignInButton.click();
        return new SignInPage();
    }

    @Step("Verify SignIn")
    public String getSignInMessage() {
        logger.debug("Successfully retrieved sign in message");
        return signInMessage.getText();
    }

    @Step("Open registration page")
    public RegistrationPage openRegistrationPage() {
        registrationButton.click();
        logger.debug("Clicked successfully on the registration page button");
        return new RegistrationPage();
    }
}