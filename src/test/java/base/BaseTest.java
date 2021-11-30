package base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.CatalogPage;
import pages.ElectronicsPage;
import pages.HomePage;
import pages.SmartphonePage;
import webdriver.DriverFactory;
import webdriver.DriverManager;

public class BaseTest {
    protected HomePage homePage;
    protected CatalogPage catalogPage;
    protected ElectronicsPage electronicsPage;
    protected SmartphonePage smartphonePage;

    @BeforeClass
    public void setUpDriver() {
        DriverManager.setDriver(DriverFactory.getDriver(DriverFactory.BrowserType.CHROME));
    }

    @BeforeClass
    public void setUpPages() {
        homePage = new HomePage(DriverManager.getDriver());
        catalogPage = new CatalogPage(DriverManager.getDriver());
        electronicsPage = new ElectronicsPage(DriverManager.getDriver());
        smartphonePage = new SmartphonePage(DriverManager.getDriver());
    }

    @AfterClass
    public void tearDown() {
        DriverManager.quiteDriver();
    }
}