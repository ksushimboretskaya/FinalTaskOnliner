package testPages;

import base.BaseTest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger("Home page test logger");

    @Test(priority = 1, description = "Verify smartphone page tittle, test-case #1")
    public void verifySmartphonePageTitle() {
        logger.info("Start 'verify smartphone page tittle' test");
        String actualSmartphonePageTittle = new HomePage().clickOnCatalogsPageLink()
                .clickOnElectronicsPageLink()
                .clickOnMobilePhoneLink()
                .clickOnSmartphoneLink()
                .getPageHeaderTitle();

        Assert.assertEquals(actualSmartphonePageTittle, "Мобильные телефоны", "The actual page title doesn't match expected");
    }
}