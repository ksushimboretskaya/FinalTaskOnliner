package testPages;

import base.BaseTest;
import io.qameta.allure.Description;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;

@Listeners(TestListener.class)
public class HomePageTest extends BaseTest {

    @Test(priority = 1, description = "[TC#1] - Verify smartphone page tittle")
    @Description("Test case description: verify smartphone page tittle on Smartphone page")
    public void verifySmartphonePageTitle() {
        String actualSmartphonePageTittle = new HomePage().clickOnCatalogsPageButton()
                .clickOnElectronicsPageButton()
                .clickOnMobilePhoneButton()
                .clickOnSmartphoneButton()
                .getPageHeaderText();
        Assert.assertEquals(actualSmartphonePageTittle, "Мобильные телефоны", "The actual page title doesn't match expected");
    }

    @Test(priority = 2, description = "[TC#4] -  Check logo on the site")
    @Description("Test case description:  Check logo on the site")
    public void verifyLogoOnTheSite() {
        String currentURL = new HomePage().refreshPage().clickOnTheLogotype().getPageUrl();
        Assert.assertEquals(currentURL, ONLINER_URL, "The actual page doesn't match expected");
    }

    @Test(priority = 3, description = "[TC#3 - Check searching system")
    @Description("Test case description: check searching system with negative data")
    public void verifySearchingSystemWithNegativeData() {
        String actualSearchData = new HomePage().searchQueryInput().getSearchData();
        Assert.assertNotEquals(actualSearchData, "Дом в Минске", "The actual search data is match expected");
    }
}