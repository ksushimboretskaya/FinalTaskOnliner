package pages;

import data.SearchQuery;
import elements.CustomButton;
import elements.CustomTextElement;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import utils.JsonUtils;

public class HomePage extends BasePage {

    private static final Logger logger = Logger.getLogger("Home page logger");
    private static final String SEARCH_DATA_FILE = "/testData/searchQuery.json";

    @FindBy(xpath = "//span[contains(@class,'b-main-navigation__text')and text() = 'Каталог']")
    private CustomButton catalogButton;

    @FindBy(xpath = "//span[contains(@class,'b-main-navigation__text')and text() = 'Услуги']")
    private CustomButton servicesButton;

    @FindBy(xpath = "//span[contains(@class,'b-main-navigation__text')and text() = 'Форум']")
    private CustomButton forumButton;

    @FindBy(className = "onliner_logo")
    private CustomButton logo;

    @FindBy(xpath = "//*[contains(@class,'fast-search__input')]")
    private CustomTextElement searchField;

    @FindBy(xpath = "//*[contains(@class,'auth-bar__item auth-bar__item--text')and text() = 'Вход']")
    private CustomButton signInButton;

    @FindBy(xpath = "(//span[contains(@class,'_u js-weather')])[1]")
    private CustomButton weatherButton;

    @FindBy(xpath = "//span[contains(@class,'_u js-currency-amount')]")
    private CustomButton courseButton;

    public HomePage() {
        super();
    }

    @Step("Click on the catalogs page button")
    public CatalogPage clickOnCatalogsPageButton() {
        catalogButton.click();
        logger.debug("Clicked successfully on the catalog page button");
        return new CatalogPage();
    }

    @Step("Click on the services page button")
    public ServicesPage clickOnTheServicesPageButton() {
        servicesButton.click();
        logger.debug("Clicked successfully on the services page button");
        return new ServicesPage();
    }

    @Step("Click on the logotype")
    public HomePage clickOnTheLogotype() {
        logo.click();
        logger.debug("Clicked successfully on the logo");
        return new HomePage();
    }

    @Step("Input text in the search field")
    public HomePage inputQueryInTheSearchField() {
        SearchQuery searchQuery = JsonUtils.readJsonSingleObject(SEARCH_DATA_FILE, SearchQuery.class);
        searchField.sendKeys(searchQuery.getSearchQuery());
        logger.debug("Successfully input text in the search field");
        return new HomePage();
    }

    @Step("Retrieve search data")
    public String getSearchData() {
        logger.debug("Successfully retrieved search data");
        return searchField.getText();
    }

    @Step("Click on the sign in button")
    public SignInPage openSignInForm() {
        signInButton.click();
        logger.debug("Clicked successfully on the sign in button");
        return new SignInPage();
    }

    @Step("Open weather page")
    public WeatherPage openWeatherPage() {
        weatherButton.click();
        logger.debug("Clicked successfully on the weather page button");
        return new WeatherPage();
    }

    @Step("Open course page")
    public CoursePage openCoursePage() {
        courseButton.click();
        logger.debug("Clicked successfully on the course page button");
        return new CoursePage();
    }

    @Step("Open forum page")
    public ForumPage openForumPage() {
        forumButton.click();
        logger.debug("Clicked successfully on the forum page button");
        return new ForumPage();
    }
}