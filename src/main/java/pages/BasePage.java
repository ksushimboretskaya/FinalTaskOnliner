package pages;

import elements.CustomElementDecorator;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import webdriver.DriverManager;

public class BasePage {

    private static final Logger logger = Logger.getLogger("Base page logger");

    protected WebDriver driver;

    public BasePage() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(new CustomElementDecorator(this.driver), this);
    }

    @Step("Get page url")
    public String getPageUrl() {
        logger.debug("Successfully retrieved page url");
        return driver.getCurrentUrl();
    }
}