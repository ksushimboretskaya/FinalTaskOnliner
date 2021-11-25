package pages;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Base {

    @FindBy(xpath = "//span[contains(@class,'b-main-navigation__text')and text() = 'Каталог']")
    private WebElement catalogLink;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void clickOnCatalogsPageLink() {
        catalogLink.click();
        new CatalogPage();
    }
}