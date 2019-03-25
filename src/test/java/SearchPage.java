import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


public class SearchPage {
    private WebDriver driver;

    @FindBy(xpath = "//li[contains (@class, 'search-result ')]")
    private List<WebElement> searchResultElements;

    @FindBy(xpath = "//h3[contains (@class, 'search-results__total')]")
    private WebElement resultsTotall;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return resultsTotall.isDisplayed()
                && driver.getCurrentUrl().contains("/search")
                && driver.getTitle().contains("Search");
    }

    public int getSearchResulCount () { return searchResultElements.size();}


    public List<String> getSearchResultLists() {
        List<String> searchResultsList = new ArrayList<String>();
        for(WebElement searchResultElement : searchResultElements){
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", searchResultElement);
            searchResultsList.add(searchResultElement.getText());
        }
        return searchResultsList;
    }
}


