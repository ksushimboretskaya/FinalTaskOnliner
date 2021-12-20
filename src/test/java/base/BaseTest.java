package base;

import com.google.common.collect.ImmutableMap;
import configuration.BrowserConfig;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import webdriver.DriverFactory;
import webdriver.DriverManager;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class  BaseTest {
    public static final String ONLINER_URL = "https://www.onliner.by/";
    private static final Logger logger = LogManager.getLogger("Base test logger");

    @BeforeSuite(description = "Set up browser driver")
    public void setUp() {
        DriverManager.setDriver(DriverFactory.getDriver(BrowserConfig.getType()));
    }

    @BeforeSuite(description = "Set up allure environment")
    public void setUpAllureEnvironment() {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", BrowserConfig.getType().toString())
                        .build(), System.getProperty("user.dir")
                        + "/allure-results/");
    }

    @BeforeClass(description = "Set up base page")
    public void setUpPages() {
        DriverManager.getDriver().get(ONLINER_URL);
        logger.debug("Opening website: " + ONLINER_URL);
    }

    @AfterSuite(description = "Quit driver")
    public void tearDown() {
        DriverManager.quitDriver();
    }
}