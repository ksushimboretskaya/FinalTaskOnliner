package steps;

import base.TestBase;
import pages.CatalogPage;
import pages.ElectronicsPage;
import pages.HomePage;
import pages.Smartphone;

public class HomePageTestSteps extends TestBase {
    HomePage homePage = new HomePage();
    ElectronicsPage electronicsPage = new ElectronicsPage();
    CatalogPage catalogPage = new CatalogPage();
    Smartphone smartphone = new Smartphone();

    public void switchToTheSmartphonePage() {
        homePage.clickOnCatalogsPageLink();
        catalogPage.clickOnElectronicsPageLink();
        electronicsPage.clickOnMobilePhoneLink();
        electronicsPage.clickOnSmartphoneLink();
    }
    public String getTittle() {
        switchToTheSmartphonePage();
        return smartphone.getPageHeaderTitle();
    }
}