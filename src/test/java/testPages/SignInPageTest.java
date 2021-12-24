package testPages;

import base.BaseTest;
import io.qameta.allure.Description;
import listeners.OnlinerTestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;

@Listeners(OnlinerTestListener.class)
public class SignInPageTest extends BaseTest {
    private static final String EXPECTED_SIGN_IN_MESSAGE = "Успешно";

    @Test(priority = 5, description = "[TC#5] - Check authorization with incorrect password")
    @Description("Test case description: check authorization with incorrect password")
    public void checkAuthorizationWithIncorrectPassword() {
        String actualSignInMessage = new HomePage().openSignInForm().signInWithIncorrectData().getSignInMessage();

        Assert.assertNotEquals(actualSignInMessage, EXPECTED_SIGN_IN_MESSAGE, "The actual message doesn't match expected");
    }

    @Test(priority = 9, description = "[TC#8] - Check authorization without data")
    @Description("Test case description: check authorization without login and password")
    public void checkAuthorizationWithoutLoginAndPassword() {
        String actualSignInMessage = new HomePage().openSignInForm().signInWithoutLoginAndPassword().getSignInMessage();

        Assert.assertNotEquals(actualSignInMessage, EXPECTED_SIGN_IN_MESSAGE, "The actual message doesn't match expected");
    }
}