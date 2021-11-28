package testPages;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test(priority = 1, description = "Check a selection of related products for the 'mobile phone' section")
    public void verifySmartphonePageTitle() {
        homePage.clickOnCatalogsPageLink();
        catalogPage.clickOnElectronicsPageLink();
        electronicsPage.clickOnMobilePhoneLink();
        electronicsPage.clickOnSmartphoneLink();

        Assert.assertEquals(smartphonePage.getPageHeaderTitle(), "Мобильные телефоны");
    }
}
