package pages;

import constants.DribbbleJobPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.util.List;

public class DribbbleJobsPage  {
    private WebDriver driver;

    private By locationField = By.id(DribbbleJobPageLocators.LOCATION_FIELD);
    private By distance = By.id(DribbbleJobPageLocators.DISTANCE);
    private By openToRemoteCheckbox = By.id(DribbbleJobPageLocators.REMOTE);
    private By fullTimeCheckbox = By.id(DribbbleJobPageLocators.FULL_TIME);
    private By freelanceContractCheckbox = By.id(DribbbleJobPageLocators.CONTRACT);
    private By filterButton = By.cssSelector(DribbbleJobPageLocators.FILTER_BUTTON);
    private By resultLocation = By.className(DribbbleJobPageLocators.RESULT_LOCATION);

    public DribbbleJobsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterLocation(String location) {
        WebElement locationElement = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(locationField));
        locationElement.clear();
        locationElement.sendKeys(location);
    }

    public void checkOpenToRemote() {
        WebElement checkbox = driver.findElement(openToRemoteCheckbox);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void checkFullTime() {
        WebElement checkbox = driver.findElement(fullTimeCheckbox);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void checkFreelanceContract() {
        WebElement checkbox = driver.findElement(freelanceContractCheckbox);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void clickFilterButton() {
        System.out.println("Waiting for filter button to be clickable.");
        WebElement button = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(filterButton));
        System.out.println("Filter button is clickable.");
        button.click();
        System.out.println("Filter button clicked.");
    }


    //SEE COMMENTS ABOUT THIS METHOD IN FilterJobsByLocation Test class

    public boolean isAtLeastOneResultMatchingLocation(String location) {
        List<WebElement> results = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(resultLocation));

        for (WebElement result : results) {
            String resultLocationText = result.getText().toLowerCase();
            if (resultLocationText.contains(location.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

}