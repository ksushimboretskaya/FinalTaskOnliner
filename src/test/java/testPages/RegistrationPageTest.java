package testPages;

import base.BaseTest;
import io.qameta.allure.Description;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;

@Listeners(TestListener.class)
public class RegistrationPageTest extends BaseTest {

    private static final String EMPTY_LOGIN = "";
    private static final String EMPTY_PASSWORD = "";

    @Test(priority = 1, description = "[TC#10] - Verify registration without data")
    @Description("Verify registration without login and password")
    public void verifyRegistrationWithoutLoginAndPassword() {
        boolean registration = new HomePage().openSignInForm().openRegistrationPage().enterTheEmptyLoginAndPassword(EMPTY_LOGIN, EMPTY_PASSWORD).verifyErrorMessage();
        Assert.assertTrue(registration, "The registration actual state doesn't match expected");
    }
}