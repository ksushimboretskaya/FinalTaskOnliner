package pages;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Smartphone extends Base {
    @FindBy(xpath = "//*[contains(@class,'schema-header__title') and text()='Мобильные телефоны']")
    private WebElement header;

    public Smartphone() {
        PageFactory.initElements(driver, this);}

    public String getPageHeaderTitle() {
        return header.getText();
    }
}