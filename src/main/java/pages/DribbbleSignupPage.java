package pages;

import constants.DribbbleSignupPageLocator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DribbbleSignupPage extends BasePage {

    private WebDriver driver;

    private DribbbleSignupPageLocator locator;
    private By signinlink = By.cssSelector(DribbbleSignupPageLocator.SIGN_IN_LINK);
    private By signupTitle = By.tagName(DribbbleSignupPageLocator.SIGN_UP_TITLE);
    private By sign_up_with_google = By.xpath(DribbbleSignupPageLocator.SIGN_UP_WITH_GOOGLE_BUTTON);
    private By sign_up_with_email = By.xpath(DribbbleSignupPageLocator.CONTINUE_WITH_EMAIL_BUTTON);

    private By agreeToTermsCheckbox = By.id(DribbbleSignupPageLocator.AGREE_TO_TERMS_CHECKBOX);
    private By passwordInput = By.id(DribbbleSignupPageLocator.PASSWORD_INPUT);
    private By emailInput = By.id(DribbbleSignupPageLocator.EMAIL_INPUT);
    private By usernameInput = By.id(DribbbleSignupPageLocator.USERNAME_INPUT);
    private By nameInput = By.id(DribbbleSignupPageLocator.NAME_INPUT);
    private By createAccountButton = By.cssSelector(DribbbleSignupPageLocator.CREATE_ACCOUNT_BUTTON);
    private By errorExplanation = By.id(DribbbleSignupPageLocator.ERROR_EXPLANATION);


    public DribbbleSignupPage(WebDriver driver) {

         super(driver);
        this.driver = driver;
        this.locator = new DribbbleSignupPageLocator();
    }

    public void submitCreateAccount() {
        WebElement submitBtn = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(createAccountButton));
        submitBtn.click();
    }

    public void clickSignUpWithGoogleButton() {
        driver.findElement(sign_up_with_google).click();

    }


    public DribbbleSignupPage clickContinueWithEmailButton() {
        driver.findElement(sign_up_with_email).click();
        return new DribbbleSignupPage(driver);
    }



    public DribbbleSigninPage clickSignInLink() {

        WebElement signInLink = driver.findElement(signinlink);
        signInLink.click();

        return new DribbbleSigninPage(driver);
    }


    public void checkAgreeToTerms() {
        WebElement agreeToTermsCheckboxElement = driver.findElement(agreeToTermsCheckbox);
        if (!agreeToTermsCheckboxElement.isSelected()) {
            agreeToTermsCheckboxElement.click();
        }
    }

    public void fillNameField(String name) {
        WebElement nameField = driver.findElement(nameInput);
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void fillPasswordField(String password) {
        WebElement passwordField = driver.findElement(passwordInput);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void fillEmailField(String email) {
        WebElement emailField = driver.findElement(emailInput);
        emailField.clear();
        emailField.sendKeys(email);
    }
    public String getErrorMessage() {
        try {

            WebElement errorMessageElement = driver.findElement(By.cssSelector(".errorExplanation"));
            return errorMessageElement.isDisplayed() ? errorMessageElement.getText() : null;
        } catch (NoSuchElementException e) {
            return null;
        }
    }


    public void fillUsernameField(String username) {
        WebElement usernameField = driver.findElement(usernameInput);
        usernameField.clear();
        usernameField.sendKeys(username);
    }


    public DribbbleSignedInUserHomePage submit_Create_Account() {
        driver.findElement(createAccountButton).click();
        return new DribbbleSignedInUserHomePage(driver);
    }

    public boolean isAlertDisplayed(String expectedMessage) {
        WebElement alertElement = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(errorExplanation));
        String alertText = alertElement.getText();
        return alertText.contains(expectedMessage);
    }


}


