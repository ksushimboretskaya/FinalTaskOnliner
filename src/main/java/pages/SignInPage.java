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

    public SignInPage() {
        super();
    }

    @Step("Input correct login and incorrect password")
    public SignInPage signInWithIncorrectData() {
        loginField.sendKeys("kshimboretskaya@mail.ru");
        logger.debug("Successfully input login");
        passwordField.sendKeys("ksusha123");
        logger.debug("Successfully input password");
        submitSignInButton.click();
        logger.debug("Clicked successfully on the submit sign in button");
        return new SignInPage();
    }

    @Step("verifySignIn")
    public String getSignInMessage() {
        logger.debug("Successfully retrieved sign in message");
        return signInMessage.getText();
    }
}