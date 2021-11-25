package pages;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElectronicsPage extends Base {
    @FindBy(xpath = "(//*[contains(@class,'catalog-navigation-list__aside-title')])[1]")
    private WebElement mobilePhoneLink;
    @FindBy(xpath = "(//*[contains(@class,'catalog-navigation-list__dropdown-title') and text()=' Смартфоны '])[1]\n")
    private WebElement smartphoneLink;

    public ElectronicsPage() {
    PageFactory.initElements(driver,this);
}

    public void clickOnMobilePhoneLink() {
        mobilePhoneLink.click();
    }

    public void clickOnSmartphoneLink() {
        smartphoneLink.click();
        new Smartphone();
    }
}