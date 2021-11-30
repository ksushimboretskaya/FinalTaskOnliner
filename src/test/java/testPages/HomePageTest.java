package testPages;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test(priority = 1, description = "Verify smartphone page tittle")
    public void verifySmartphonePageTitle() {
        homePage.clickOnCatalogsPageLink();
        catalogPage.clickOnElectronicsPageLink();
        electronicsPage.clickOnMobilePhoneLink();
        electronicsPage.clickOnSmartphoneLink();

        Assert.assertEquals(smartphonePage.getPageHeaderTitle(), "Мобильные телефоны", "The actual page title doesn't match expected");
    }
}