package pages;

import elements.CustomButton;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;

public class DiscussionPage extends BasePage {

    private static final Logger logger = Logger.getLogger("Home page logger");

    @FindBy(xpath = "(//span[contains(text(),'Ответить')])[1]")
    private CustomButton replyButton;

    public DiscussionPage() {
        super();
    }

    @Step("Open reply form")
    public DiscussionPage openReplyForm() {
        replyButton.click();
        logger.debug("Clicked successfully in the reply button");
        return new DiscussionPage();
    }

    @Step("Get reply form url")
    public String getReplyFormURL() {
        logger.debug("Successfully retrieved reply form url");
        return driver.getCurrentUrl();
    }
}