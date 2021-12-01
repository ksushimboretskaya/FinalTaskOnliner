package base;

import configuration.BrowserConfig;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import pages.CatalogPage;
import pages.ElectronicsPage;
import pages.HomePage;
import pages.SmartphonePage;
import webdriver.DriverFactory;
import webdriver.DriverManager;

public class BaseTest {
    protected HomePage homePage = new HomePage();
    protected CatalogPage catalogPage = new CatalogPage();
    protected ElectronicsPage electronicsPage = new ElectronicsPage();
    protected SmartphonePage smartphonePage = new SmartphonePage();
    public static final String ONLINER_URL = "https://www.onliner.by/";

    @BeforeSuite
    public void setUp() {
        if (DriverManager.getDriver() != null) {
            DriverManager.setDriver(DriverFactory.getDriver(BrowserConfig.getType()));
        } else DriverManager.setDriver(DriverFactory.getDriver(DriverFactory.BrowserType.CHROME));
    }

    @BeforeClass
    public void setUpPages() {
        DriverManager.getDriver().get(ONLINER_URL);
    }

    @AfterSuite
    public void tearDown() {
        DriverManager.quiteDriver();
    }
}