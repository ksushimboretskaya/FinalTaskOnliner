package testPages;

import base.BaseTest;
import io.qameta.allure.Description;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;

@Listeners(TestListener.class)
public class SignInPageTest extends BaseTest {

    private static final String EXPECTED_SIGN_IN_MESSAGE = "Успешно";
    private static final String CORRECT_LOGIN = "kseniya123@mail.ru";
    private static final String EMPTY_LOGIN = "";
    private static final String EMPTY_PASSWORD = "";

    @Test(priority = 1, description = "[TC#5] - Check authorization with incorrect password", dataProvider = "incorrectPasswords")
    @Description("Test case description: check authorization with incorrect password")
    public void checkAuthorizationWithIncorrectPassword(String password) {
        String actualSignInMessage = new HomePage().openSignInForm().enterLoginAndPassword(CORRECT_LOGIN, password).getSignInMessage();
        Assert.assertNotEquals(actualSignInMessage, EXPECTED_SIGN_IN_MESSAGE, "The actual message doesn't match expected");
    }

    @Test(priority = 2, description = "[TC#8] - Check authorization without data")
    @Description("Test case description: check authorization without login and password")
    public void checkAuthorizationWithoutLoginAndPassword() {
        String actualSignInMessage = new HomePage().refreshPage().openSignInForm().enterLoginAndPassword(EMPTY_LOGIN, EMPTY_PASSWORD).getSignInMessage();
        Assert.assertNotEquals(actualSignInMessage, EXPECTED_SIGN_IN_MESSAGE, "The actual message doesn't match expected");
    }

    @DataProvider(name = "incorrectPasswords")
    public Object[][] incorrectPassword() {
        return new Object[][]{{"ksusha1234"}};
    }
}