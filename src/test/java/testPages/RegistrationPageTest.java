package testPages;

import base.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class RegistrationPageTest extends BaseTest {

    @Test(priority = 10, description = "[TC#10] - Verify registration without data")
    @Description("Verify registration without login and password")
    public void verifyRegistrationWithoutLoginAndPassword() {
        boolean registration = new HomePage().openSignInForm().openRegistrationPage().registrationWithoutData().verifyErrorMessage();
        Assert.assertTrue(registration, "The actual value doesn't match expected");
    }
}