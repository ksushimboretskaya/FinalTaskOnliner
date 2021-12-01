package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private static final String CHROMEDRIVER_EXE_PATH = "src/main/resources/chromedriver.exe";
    public static final int IMPLICITLY_WAIT = 10;

    public enum BrowserType {FIREFOX, CHROME, EDGE, IE}

    public static WebDriver getDriver(BrowserType type) {
        WebDriver driver = null;
        switch (type) {
            case CHROME:
                driver = getChromeDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT, TimeUnit.SECONDS);
        System.out.println(type + "browser started");
        return driver;
    }

    private static ChromeDriver getChromeDriver() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, CHROMEDRIVER_EXE_PATH);
        return new ChromeDriver();
    }
}