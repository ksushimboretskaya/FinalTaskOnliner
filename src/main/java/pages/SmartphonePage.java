package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SmartphonePage extends BasePage {
    @FindBy(xpath = "//*[contains(@class,'schema-header__title') and text()='Мобильные телефоны']")
    private WebElement header;

    public SmartphonePage() {
        super();
    }

    public String getPageHeaderTitle() {
        return header.getText();
    }
}