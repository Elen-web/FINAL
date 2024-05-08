package pages;

import constants.ContactDribbbleLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactDribbblePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By billingSection = By.cssSelector(ContactDribbbleLocator.BILLING);
    private By receiptsOption = By.cssSelector(ContactDribbbleLocator.RECEIPTS_OPTION);
    private By contactButton = By.cssSelector(ContactDribbbleLocator.CONTACT_BUTTON);
    private By chooseTopic = By.cssSelector(ContactDribbbleLocator.CHOOSE_TOPIC);
    private By generalSupportOption = By.cssSelector(ContactDribbbleLocator.GENERAL_SUPPORT);
    private By submitButton = By.cssSelector("input[type='submit']");
    private By descriptionTextArea = By.id("request_description");
    private By subjectInput = By.id("request_subject");
    private By emailInput = By.id("request_anonymous_requester_email");
    private By nameInput = By.id("request_custom_fields_360054977294");
    private By usernameInput = By.id("request_custom_fields_360056133733");

    public ContactDribbblePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void clickBillingSection() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(billingSection));
        element.click();
    }

    public void clickReceiptsOption() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(receiptsOption));
        element.click();
    }

    public void clickContactButton() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(contactButton));
        element.click();
    }

    public void clickChooseTopic() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(chooseTopic));
        element.click();
    }

    public void selectGeneralSupportOption() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(generalSupportOption));
        element.click();
    }

    public void enterDescription(String description) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(descriptionTextArea));
        element.clear();
        element.sendKeys(description);
    }

    public void enterSubject(String subject) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(subjectInput));
        element.clear();
        element.sendKeys(subject);
    }

    public void enterEmail(String email) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        element.clear();
        element.sendKeys(email);
    }

    public void enterName(String name) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(nameInput));
        element.clear();
        element.sendKeys(name);
    }

    public void enterUsername(String username) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
        element.clear();
        element.sendKeys(username);
    }

    public void clickSubmitButton() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        element.click();
    }

    public boolean isContactPageLoaded() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(contactButton)).isDisplayed();
    }

    public boolean isBillingSectionLoaded() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(billingSection)).isDisplayed();
    }

    public boolean isContactFormLoaded() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton)).isDisplayed();
    }
}
