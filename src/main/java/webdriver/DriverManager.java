package webdriver;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static WebDriver driver = null;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public static void quiteDriver() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
        }
    }
}