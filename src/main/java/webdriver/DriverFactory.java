package webdriver;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private static final String CHROMEDRIVER_EXE_PATH = "src/main/resources/chromedriver.exe";
    private static final Logger logger = LogManager.getLogger("Driver factory logger");
    public static final int IMPLICITLY_WAIT = 10;
    public static final int PAGE_LOAD_TIMEOUT = 40;

    public enum BrowserType {FIREFOX, CHROME, EDGE, IE}

    public static WebDriver getDriver(BrowserType type) {
        WebDriver driver;
        switch (type) {
            case CHROME:
                driver = getChromeDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser name" + type);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        logger.info(type + " browser started");
        return driver;
    }

    private static ChromeDriver getChromeDriver() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, CHROMEDRIVER_EXE_PATH);
        return new ChromeDriver();
    }
}