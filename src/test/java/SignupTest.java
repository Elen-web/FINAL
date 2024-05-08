
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.junit.Assert;
import pages.DribbbleHomePage;
import pages.DribbbleSigninPage;
import pages.DribbbleSignupPage;

public class SignupTest extends BaseTest {


    @Test(description = "Invalid Sign Up Test - Missing Email")
    public void invalidSignUpTestMissingEmail() {
        DribbbleSignupPage signupPage = homePage.clickSignUpButton();
        signupPage.clickContinueWithEmailButton();
        signupPage.fillNameField("Soft Test");
        signupPage.fillUsernameField("sttest321");
        signupPage.fillPasswordField("Passw77jd123");
        signupPage.fillEmailField(""); // Intentionally missing email
        signupPage.checkAgreeToTerms();
        String errorMessage = signupPage.getErrorMessage();
        Assert.assertNotNull(errorMessage, "No error message displayed when expected.");

    }

    @Test(description = "Valid Sign Up Test")
    public void validSignUpTest() {
        DribbbleSignupPage signupPage = homePage.clickSignUpButton();
        signupPage.clickContinueWithEmailButton();
        signupPage.fillNameField("Soft Test");
        signupPage.fillUsernameField("sttest321");
        signupPage.fillPasswordField("Passw77jd123");
        signupPage.fillEmailField("softtest@gmail.com.com");
        signupPage.checkAgreeToTerms();

    }



    @Test(description = "Invalid Sign Up Test - Missing Email", groups = {"signUp"})
    public void invalidSignUpMissingEmailTest() throws InterruptedException {
        DribbbleHomePage homePage = new DribbbleHomePage(driver);
        DribbbleSignupPage signUpPage = homePage.clickSignUpButton();
        signUpPage.fillPasswordField("validPassword");
        signUpPage.submitCreateAccount();
        Assert.assertTrue(signUpPage.isAlertDisplayed("Please enter your email"));
    }




    @Test
    public void navigateToResetPasswordPage() {
        DribbbleSignupPage signupPage = homePage.clickSignUpButton();
        signupPage.clickContinueWithEmailButton();

        DribbbleSigninPage signinPage = signupPage.clickSignInLink();
        signinPage.clickForgotPasswordLink();

        Assert.assertTrue("Reset password form should be visible", driver.findElement(By.id("reset-password-form")).isDisplayed());
    }



//
//    @Test
//    public void navigateToResetPasswordPage() {
//
//        WebDriver driver = new ChromeDriver();
//        DribbbleHomePage homePage = new DribbbleHomePage(driver);
//
//        homePage.clickSignUpButton();
//        DribbbleSignupPage signupPage = new DribbbleSignupPage(driver);
//        signupPage.clickContinueWithEmailButton();
//
//        DribbbleSigninPage signinPage = new DribbbleSigninPage(driver);
//        signinPage.clickForgotPasswordLink();
//
//
//        driver.quit();
//    }
}







