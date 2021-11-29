package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElectronicsPage extends BasePage {
    @FindBy(xpath = "(//*[contains(@class,'catalog-navigation-list__aside-title')])[1]")
    private WebElement mobilePhoneLink;
    @FindBy(xpath = "(//*[contains(@class,'catalog-navigation-list__dropdown-title') and text()=' Смартфоны '])[1]")
    private WebElement smartphoneLink;

    public ElectronicsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnMobilePhoneLink() {
        mobilePhoneLink.click();
    }

    public void clickOnSmartphoneLink() {
        smartphoneLink.click();
    }
}