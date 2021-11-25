package pages;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatalogPage extends Base {
    @FindBy(xpath = "//span[contains(@class,'catalog-navigation-classifier__item-title') and text() ='Электроника']")
    private WebElement electronicsLink;

    public CatalogPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickOnElectronicsPageLink() {
        electronicsLink.click();
        new ElectronicsPage();
    }
}