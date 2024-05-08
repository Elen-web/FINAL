import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DribbbleHomePage;
import pages.DribbbleSearchResultsPage;

public class SearchPageTest extends BaseTest {
    DribbbleSearchResultsPage resultsPage;
    DribbbleHomePage homePage;


    @DataProvider
    public static Object[][] validKeywords() {
        return dataProvider.VALID_SEARCH_KEYWORDS;
    }

    @DataProvider
    public static Object[][] invalidKeywords() { return dataProvider.INVALID_SEARCH_KEYWORDS;}

    @DataProvider
    public static Object[][] edgeCaseKeywords() { return dataProvider.EDGE_CASE_SEARCH_KEYWORDS;}


//Because the results do not have titles, I am searching fot the authors, and comparing them with the list of results

    @Test(dataProvider = "validKeywords", description = "Search with valid keywords")
    public void testValidSearch(String keyword) {
        homePage = new DribbbleHomePage(driver);
        DribbbleSearchResultsPage searchResultsPage = homePage.fillSearchField(keyword);
        Assert.assertTrue("Results should be found for valid keyword: " + keyword, searchResultsPage.getResultsCount() > 0);
        Assert.assertTrue("Search results should contain the keyword in the authors: " + keyword, searchResultsPage.compareResultsWithKeyword(keyword));
    }

    //The problem is, the website does not provide error messages when the input is "invalid

    @Test(dataProvider = "invalidKeywords", description = "Search with invalid keywords")
    public void testInvalidSearch(String keyword) {
        DribbbleHomePage homePage = new DribbbleHomePage(driver);
        DribbbleSearchResultsPage searchResultsPage = homePage.fillSearchField(keyword);
        Assert.assertTrue("Results should not be found for invalid keyword: " + keyword, searchResultsPage.getResultsCount() == 0);
    }

    @Test(dataProvider = "edgeCaseKeywords", description = "Search with edge case keywords")
    public void testEdgeCaseSearch(String keyword) {
        DribbbleHomePage homePage = new DribbbleHomePage(driver);
        DribbbleSearchResultsPage searchResultsPage = homePage.fillSearchField(keyword);
        Assert.assertTrue("Results count for edge case keyword: "
                + keyword, searchResultsPage.getResultsCount() >= 0);
    }


}
