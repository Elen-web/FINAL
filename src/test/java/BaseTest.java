import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.DribbbleHomePage;
import pages.DribbbleSigninPage;
import pages.DribbbleSignupPage;
import pages.DribbbleSearchResultsPage;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    protected WebDriver driver;
    protected DribbbleSearchResultsPage searchPage;
    protected DribbbleHomePage homePage;
    protected DribbbleSigninPage signinPage;
    protected DribbbleSignupPage signupPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
    }

    @BeforeMethod
    public void goHome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"--remote-allow-origins=*"});
        this.driver = new ChromeDriver(options);
        this.driver.manage().window().maximize();
        this.driver.get("https://dribbble.com/");
        this.homePage = new DribbbleHomePage(this.driver);

        this.signupPage = new DribbbleSignupPage(this.driver); //take away
    }



    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus())
        { var cam = (TakesScreenshot) driver;
            File screenshot = cam.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            }catch (IOException e){
                e.printStackTrace();
            }
        }   driver.quit();
    }

}

