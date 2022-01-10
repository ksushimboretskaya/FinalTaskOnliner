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

    @Test(priority = 1, description = "[TC#10] - Verify registration without data")
    @Description("Verify registration without login and password")
    public void verifyRegistrationWithoutLoginAndPassword() {
        boolean registration = new HomePage().openSignInForm().openRegistrationPage().registerWithoutLoginAndPassword().verifyErrorMessage();
        Assert.assertTrue(registration, "The registration completed successfully");
    }
}