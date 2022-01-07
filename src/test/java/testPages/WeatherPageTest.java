package testPages;

import base.BaseTest;
import io.qameta.allure.Description;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;

@Listeners(TestListener.class)
public class WeatherPageTest extends BaseTest {

    private static final String WEATHER_PAGE_URL = "https://pogoda.onliner.by/";

    @Test(priority = 1, description = "[TC#6] - Check weather icon")
    @Description("Test case description: check weather icon")
    public void checkWeatherIcon() {
        String actualURL = new HomePage().openWeatherPage().getPageUrl();
        Assert.assertEquals(actualURL, WEATHER_PAGE_URL, "The actual url doesn't match expected");
    }
}