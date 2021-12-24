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

    @Test(priority = 5, description = "[TC#5 - Check authorization with incorrect password")
    @Description("Test case description: check authorization with incorrect password")
    public void checkAuthorizationWithIncorrectPassword() {
        String actualSignInMessage = new HomePage().openSignInForm().signInWithIncorrectData().getSignInMessage();

        Assert.assertNotEquals(actualSignInMessage, "Успешно", "The actual message doesn't match expected");
    }
}