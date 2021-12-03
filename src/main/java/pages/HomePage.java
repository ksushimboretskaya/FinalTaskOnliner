package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//span[contains(@class,'b-main-navigation__text')and text() = 'Каталог']")
    private WebElement catalogLink;

    public HomePage() {
        super();
    }

    public CatalogPage clickOnCatalogsPageLink() {
        catalogLink.click();
        return new CatalogPage();
    }
}