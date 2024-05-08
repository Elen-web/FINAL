package pages;

import constants.DribbbleHomePageLocator;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DribbbleHomePage {

    private WebDriver driver;
    DribbbleHomePage homePage;

    private By searchField = By.cssSelector(DribbbleHomePageLocator.SEARCH_FIELD);
    private By getStartedButton = By.cssSelector(DribbbleHomePageLocator.GET_STARTED_BUTTON);
    private By signUpButton = By.cssSelector(DribbbleHomePageLocator.SIGN_UP_BUTTON);
    private By logInButton = By.cssSelector(DribbbleHomePageLocator.LOG_IN_BUTTON);
    private By jobsLink = By.cssSelector(DribbbleHomePageLocator.JOBS_lINK);
    private By supportLink = By.cssSelector(DribbbleHomePageLocator.SUPPORT_LINK);

    public DribbbleHomePage(WebDriver driver) {
        this.driver = driver;

    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://dribbble.com/");
        homePage = new DribbbleHomePage(driver);
    }

    public DribbbleSearchResultsPage fillSearchField(String keyword) {
        WebElement searchFieldElement = driver.findElement(searchField);
        searchFieldElement.clear();
        searchFieldElement.sendKeys(keyword);
        searchFieldElement.sendKeys(Keys.RETURN); // Simulate pressing Enter key
        return new DribbbleSearchResultsPage(driver);
    }

    public void search(String query) {
        driver.findElement(searchField).sendKeys(query);
        driver.findElement(searchField).submit();
    }

    public DribbbleSignupPage clickSignUpButton() {
        driver.findElement(signUpButton).click();
        return new DribbbleSignupPage(driver);
    }


    public DribbbleSigninPage clickLoginButton() {
        driver.findElement(logInButton).click();
        return new DribbbleSigninPage(driver);
    }

    public DribbbleSignupPage clickGetStartedButton() {
        driver.findElement(getStartedButton).click();
        return new DribbbleSignupPage(driver);
    }


    public DribbbleHiringPage clickFindDesigners() {
        driver.findElement(By.cssSelector(DribbbleHomePageLocator.FIND_DESIGNERS_LINK)).click();
        return new DribbbleHiringPage(driver);
    }


    public  ContactDribbblePage clickSupportLink() {
        driver.findElement(supportLink).click();
       return new ContactDribbblePage(driver);

    }

    public DribbbleJobsPage navigateToJobSearchPage() {
        driver.findElement(jobsLink).click();
        WebElement jobSearchElement = driver.findElement(jobsLink);
        jobSearchElement.click();
        return new DribbbleJobsPage(driver);
    }




//    public DribbbleSearchResultsPage searchForKeyword(String keyword) {
//        WebElement searchFieldElement = driver.findElement(searchField);
//        searchFieldElement.clear();
//        searchFieldElement.sendKeys(keyword);
//        //driver.findElement(searchField).click();
//        return new DribbbleSearchResultsPage(driver);
//    }

}
