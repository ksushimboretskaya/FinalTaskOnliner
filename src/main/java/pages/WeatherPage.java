package pages;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;

public class WeatherPage extends BasePage {
    private static final Logger logger = Logger.getLogger("Weather page logger");

    public WeatherPage() {
        super();
    }

    @Step("Get page URL")
    public String getPageWeatherURL() {
        logger.debug("Successfully retrieved weather page url");
        return driver.getCurrentUrl();
    }
}