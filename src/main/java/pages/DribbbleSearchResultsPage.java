package pages;

import constants.SearchLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DribbbleSearchResultsPage extends SearchLocators {
    private WebDriver driver;

    private By body = By.id(SearchLocators.BODY_OF_RESULTS);
    private By authorNames = By.className(SearchLocators.AUTHORS_NAMES);


        public DribbbleSearchResultsPage(WebDriver driver) {
            this.driver = driver;
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.visibilityOfElementLocated(body));
        }

        public int getResultsCount() {
            List<WebElement> results = driver.findElements(authorNames);
            return results.size();
        }

        public boolean compareResultsWithKeyword(String keyword) {
            List<WebElement> results = driver.findElements(authorNames);
            for (WebElement result : results) {
                if (!result.getText().toLowerCase().contains(keyword.toLowerCase())) {
                    return false;
                }
            }
            return true;
        }
    }


