package pages;

import elements.CustomButton;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;

public class ForumPage extends BasePage {

    private static final Logger logger = Logger.getLogger("Forum page logger");

    @FindBy(xpath = "//*[contains(@class,'forumtitle') and text()='Операторы связи']")
    private CustomButton operatorDiscussionButton;

    public ForumPage() {
        super();
    }

    @Step("Open discussion 'Операторы связи'")
    public ChooseDiscussionPage openChooseDiscussionPage() {
        operatorDiscussionButton.click();
        logger.debug("Clicked successfully on the open discussion button");
        return new ChooseDiscussionPage();
    }
}