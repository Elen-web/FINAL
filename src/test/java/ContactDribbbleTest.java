import org.junit.Assert;
import org.testng.annotations.Test;
import pages.ContactDribbblePage;
import pages.DribbbleHomePage;

public class ContactDribbbleTest extends BaseTest{

    ContactDribbblePage contactDribbblePage;



    @Test(description = "Navigate to Contact Dribbble page by clicking on Support link")
    public void navigateToContactDribbblePage() {
        DribbbleHomePage homePage = new DribbbleHomePage(driver);
        ContactDribbblePage contactPage = homePage.clickSupportLink();
        Assert.assertTrue("Contact Dribbble page should be loaded.", contactPage.isContactPageLoaded());
    }


        @Test(description = "Navigate to Contact Dribbble page by clicking on Support link")
        public void navigateToContactDribbblePageAndMore() {
            DribbbleHomePage homePage = new DribbbleHomePage(driver);
            ContactDribbblePage contactPage = homePage.clickSupportLink();
            Assert.assertTrue("Contact Dribbble page should be loaded.", contactPage.isContactPageLoaded());
            contactPage.clickBillingSection();
            contactPage.clickChooseTopic();
            contactPage.selectGeneralSupportOption();
            contactPage.enterDescription("This is a test description.");
            contactPage.enterSubject("Test Subject");
            contactPage.enterEmail("test@example.com");
            contactPage.enterName("Test Name");
            contactPage.enterUsername("testusername");
            contactPage.clickSubmitButton();


        }
    }






