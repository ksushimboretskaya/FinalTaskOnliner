package pages;

import elements.CustomTextElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ServicesPage extends BasePage {
    @FindBy(xpath = "(//*[contains(@class,'i-checkbox service-form__checkbox service-form__checkbox_base')])[1]")
    private WebElement regionCheckBox;

    @FindBy(xpath = "//span[contains(@class,'service-offers__details-item service-offers__details-item_map-marker ng-binding ng-scope')]")
    private CustomTextElement location;

    public ServicesPage() {
        super();
    }

    @Step("Choose the region 'Минск'")
    public ServicesPage clickOnTheCheckBox() {
        regionCheckBox.click();
        return new ServicesPage();
    }

    @Step("Check region of item")
    public String checkRegion() {
        return location.getText();
    }
}