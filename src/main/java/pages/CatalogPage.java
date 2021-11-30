package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CatalogPage extends BasePage {
    @FindBy(xpath = "//span[contains(@class,'catalog-navigation-classifier__item-title') and text() ='Электроника']")
    private WebElement electronicsLink;

    public CatalogPage() {
        super();
    }

    public void clickOnElectronicsPageLink() {
        electronicsLink.click();
    }
}