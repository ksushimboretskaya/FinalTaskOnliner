package testPages;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends BaseTest {

    @Test(priority = 1, description = "[TC#1] - Verify smartphone page tittle")
    public void verifySmartphonePageTitle() {
        String actualSmartphonePageTittle = new HomePage().clickOnCatalogsPageButton()
                .clickOnElectronicsPageButton()
                .clickOnMobilePhoneButton()
                .clickOnSmartphoneButton()
                .getPageHeaderText();

        Assert.assertEquals(actualSmartphonePageTittle, "Мобильные телефоны", "The actual page title doesn't match expected");
    }
}