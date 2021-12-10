package pages;

import elements.CustomElementDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import webdriver.DriverManager;

public class BasePage {
    protected WebDriver driver;

    public BasePage() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(new CustomElementDecorator(this.driver), this);
    }
}