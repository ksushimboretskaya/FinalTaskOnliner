package testPages;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends BaseTest {

    @Test(priority = 1, description = "Verify smartphone page tittle")
    public void verifySmartphonePageTitle() {
        HomePage homePage = new HomePage();
        String actualSmartphonePageTittle = homePage.clickOnCatalogsPageLink()
                .clickOnElectronicsPageLink()
                .clickOnMobilePhoneLink()
                .clickOnSmartphoneLink()
                .getPageHeaderTitle();

        Assert.assertEquals(actualSmartphonePageTittle, "Мобильные телефоны", "The actual page title doesn't match expected");
    }
}