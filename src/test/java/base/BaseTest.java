package base;

import configuration.BrowserConfig;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import webdriver.DriverFactory;
import webdriver.DriverManager;

public class BaseTest {
    public static final String ONLINER_URL = "https://www.onliner.by/";
    private static final Logger logger = LogManager.getLogger("Base test logger");

    @BeforeSuite
    public void setUp() {
        DriverManager.setDriver(DriverFactory.getDriver(BrowserConfig.getType()));
    }

    @BeforeClass
    public void setUpPages() {
        DriverManager.getDriver().get(ONLINER_URL);
        logger.debug("Opening website: " + ONLINER_URL);
    }

    @AfterSuite
    public void tearDown() {
        DriverManager.quitDriver();
    }
}