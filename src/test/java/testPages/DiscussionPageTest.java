package testPages;

import base.BaseTest;
import jdk.jfr.Description;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;

@Listeners(TestListener.class)
public class DiscussionPageTest extends BaseTest {

    private static final String REPLY_FORM_URL = "https://forum.onliner.by/viewtopic.php?t=835386";

    @Test(priority = 10, description = "[TC#7] - Check the ability to write on the page 'Форум' for an unregistered user")
    @Description("Test case description: check the ability to write on the page 'Форум' for an unregistered user")
    public void checkTheAbilityToWriteOnThePageFoeAnUnregisteredUser() {
        String actualURL = new HomePage().openForumPage().openChooseDiscussionPage().chooseDiscussion().openReplyForm().getReplyFormURL();

        Assert.assertNotEquals(actualURL, REPLY_FORM_URL, "The actual url doesn't match expected");
    }
}