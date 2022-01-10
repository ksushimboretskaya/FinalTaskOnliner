package pages;

import elements.CustomButton;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;

public class ChooseDiscussionPage extends BasePage {

    private static final Logger logger = Logger.getLogger("Choose discussion page logger");

    @FindBy(xpath = "//*[contains(@class, 'topictitle') and text()='Задай вопрос A1']")
    private CustomButton chooseDiscussionButton;

    public ChooseDiscussionPage() {
        super();
    }

    @Step("Choose discussion")
    public DiscussionPage clickChooseDiscussionButton() {
        chooseDiscussionButton.click();
        logger.debug("Clicked successfully on the choose discussion button");
        return new DiscussionPage();
    }
}