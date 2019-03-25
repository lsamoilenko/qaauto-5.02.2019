import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class SearchTests extends BaseTest {


    @Test
    public void basicSearchTest() throws InterruptedException {
        String searchTerm = "HR";
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");

        HomePage homePage = landingPage.login("kir00plast@gmail.com", "Qwerty123");
        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded");

        SearchPage searchPage = homePage.search("HR");
        Thread.sleep(5000);
        Assert.assertTrue(searchPage.isPageLoaded(), "Search page is not loaded");
        Assert.assertEquals(searchPage.getSearchResulCount(), 10, "Search result count is wrong");

        List<String> SearchResultList = searchPage.getSearchResultLists();
        for (String searchResult : SearchResultList){
            Assert.assertTrue(searchResult.contains(searchTerm),"Search term :  "+searchTerm+" not found in: \n"+searchResult);
        }
    }

}

