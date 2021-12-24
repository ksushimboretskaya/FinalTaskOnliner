package pages;

import io.qameta.allure.Step;

public class WeatherPage extends BasePage {
    public WeatherPage() {
        super();
    }

    @Step("Get page URL")
    public String getPageWeatherURL() {
        return driver.getCurrentUrl();
    }
}
