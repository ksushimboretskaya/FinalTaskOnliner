package pages;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;

public class CoursePage extends BasePage {
    private static final Logger logger = Logger.getLogger("Course page logger");

    public CoursePage() {
        super();
    }

    @Step("Get course page url")
    public String getCoursePageUrl() {
        logger.debug("Successfully retrieved course page url");
        return driver.getCurrentUrl();
    }
}