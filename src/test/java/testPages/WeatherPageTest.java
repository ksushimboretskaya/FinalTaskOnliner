package testPages;

import base.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class WeatherPageTest extends BaseTest {
    public static final String WEATHER_PAGE_URL = "https://pogoda.onliner.by/";

    @Test(priority = 6, description = "[TC#6] - Check weather icon")
    @Description("Test case description: check weather icon")
    public void checkWeatherIcon() {
        String actualURL = new HomePage().openWeatherPage().getPageWeatherURL();

        Assert.assertEquals(actualURL, WEATHER_PAGE_URL, "The actual url doesn't match expected");
    }
}