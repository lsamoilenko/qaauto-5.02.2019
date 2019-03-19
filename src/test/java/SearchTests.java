import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class SearchTests extends BaseTest{
    @Test
    public void basicSearchTest(){
        String searchTerm = "HR";

        Assert.assertTrue(landingPage.isPageloaded(),"Landing page is not loaded.");

        HomePage homePage = landingPage.login("baddy@i.ua","Qwerty123", HomePage.class);//pattern
        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded.");

        SearchPage searchPage = homePage.search("HR");
        Assert.assertTrue(searchPage.isPageLoaded(), "Search page is not loaded.");

        Assert.assertEquals(searchPage.getSearchResultCount(),10, "Search results count is wrong.");

        List<String> searchResultsList = searchPage.getSearchResultsList();

        for(String searchResult : searchResultsList) {
            Assert.assertTrue(searchResult.contains(searchTerm),
                    "pls write this  msg"
            );
        }

    }

}
