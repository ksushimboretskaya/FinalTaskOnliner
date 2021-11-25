package testPages;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import steps.HomePageTestSteps;

public class HomePageTest extends TestBase {
    HomePageTestSteps homePageSteps;

    @BeforeClass
    public void setUp() {
        initialization();
        homePageSteps = new HomePageTestSteps();
    }

    @Test(priority = 1, description = "Check a selection of related products for the 'mobile phone' section")
    public void verifySmartphonePageTitle() {
        Assert.assertEquals(homePageSteps.getTittle(), "Мобильные телефоны");
    }
}
