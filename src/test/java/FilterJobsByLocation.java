
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DribbbleHomePage;
import pages.DribbbleJobsPage;


public class FilterJobsByLocation extends BaseTest {

/* Issues I have had while coming up for test functionality for filtering jobs by location
*  was that when searching for a location the default distance is put for (within 25 miles (40 km)
*  meaning that locations other than the one I have searched for in the location field appear
*  this makes the testing harder, so I tried to create a method that would check if
*  at least one of the locations contains/matches with the searched string
*  */

    @Test(description = "Test job search functionality with location filtering")
    public void testJobSearchWithLocationFilter1() {
        DribbbleHomePage homePage = new DribbbleHomePage(driver);
        DribbbleJobsPage jobSearchPage = homePage.navigateToJobSearchPage();

        jobSearchPage.enterLocation("New York");
        jobSearchPage.clickFilterButton();

        Assert.assertTrue(jobSearchPage.isAtLeastOneResultMatchingLocation("New York"), "At least one job search result should be located in 'New York'.");
    }

    @Test(description = "Test job search functionality with location filtering")
    public void testJobSearchWithLocationFilter() {
        DribbbleHomePage homePage = new DribbbleHomePage(driver);
        DribbbleJobsPage jobSearchPage = homePage.navigateToJobSearchPage();

        jobSearchPage.enterLocation("NJ");
        jobSearchPage.clickFilterButton();

        Assert.assertTrue(jobSearchPage.isAtLeastOneResultMatchingLocation("NJ"), "At least one job search result should be located in 'NJ'.");
    }

}

