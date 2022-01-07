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

    @FindBy(xpath = "(//*[contains(@class, 'auth-input auth-input_primary auth-input_base auth-form__input auth-form__input_width_full')])[1]")
    private CustomTextElement loginField;

    @FindBy(xpath = "(//*[contains(@class, 'auth-input auth-input_primary auth-input_base auth-form__input auth-form__input_width_full')])[2]")
    private CustomTextElement passwordField;

    @FindBy(xpath = "(//*[contains(@class, 'auth-input auth-input_primary auth-input_base auth-form__input auth-form__input_width_full')])[3]")
    private CustomTextElement repeatPasswordField;

    public RegistrationPage() {
        super();
    }

    @Step("Enter the empty login and password")
    public RegistrationPage enterTheEmptyLoginAndPassword(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        repeatPasswordField.sendKeys(password);
        clickSubmit(submitRegistrationButton);
        return new RegistrationPage();
    }

    @Step("Verify registration message")
    public boolean verifyErrorMessage() {
        return message.isDisplayed();
    }
}