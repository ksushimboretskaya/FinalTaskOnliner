package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.CatalogPage;
import pages.ElectronicsPage;
import pages.HomePage;
import pages.SmartphonePage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    public HomePage homePage;
    public CatalogPage catalogPage;
    public ElectronicsPage electronicsPage;
    public SmartphonePage smartphonePage;

    public static final String ONLINER_URL = "https://www.onliner.by/";
    public static final int IMPLICITLY_WAIT = 10;

    @BeforeClass
    public void setUpDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT, TimeUnit.SECONDS);
        driver.get(ONLINER_URL);
    }

    @BeforeClass
    public void setUpPages(){
        homePage = new HomePage(getDriver());
        catalogPage = new CatalogPage(getDriver());
        electronicsPage = new ElectronicsPage(getDriver());
        smartphonePage = new SmartphonePage(getDriver());
    }

    @AfterClass
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver(){
        return driver;
    }
}