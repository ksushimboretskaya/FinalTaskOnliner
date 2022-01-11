package testPages;

import base.BaseTest;
import io.qameta.allure.Description;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;

@Listeners({TestListener.class})
public class ServicesPageTest extends BaseTest {

    @Test(priority = 1, description = "[TC#3] -  Check filter ability in page 'Услуги'")
    @Description("Check filter ability in page 'Услуги'")
    public void verifyFilterAbility() {
        String location = new HomePage().clickOnTheServicesPageButton().chooseMinskAsRegionFilter().checkChosenRegionFilter();
        Assert.assertEquals(location, "Минск", "The actual page title doesn't match expected");
    }
}
