package testPages;

import base.BaseTest;
import io.qameta.allure.Description;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;

@Listeners(TestListener.class)
public class CoursePageTest extends BaseTest {
    private static final String COURSE_PAGE_URL = "https://kurs.onliner.by/";

    @Test(priority = 8, description = "[TC#8] - Check the course icon")
    @Description("Test case description: check the course icon")
    public void checkCoursePageUrl() {
        String actualURl = new HomePage().openCoursePage().getCoursePageUrl();

        Assert.assertEquals(actualURl, COURSE_PAGE_URL, "The actual page url doesn't match expected");
    }
}