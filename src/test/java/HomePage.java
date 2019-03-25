import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class HomePage {
    private WebDriver driver;

    @FindBy(xpath = "//form[@id='extended-nav-search']//input")
    private WebElement searchField;

    public HomePage(WebDriver driver) {//конструктор класса хоумпейдж
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return searchField.isDisplayed()
                && driver.getCurrentUrl().contains("https://www.linkedin.com/feed/")
                && driver.getTitle().contains("LinkedIn");
    }

    public SearchPage search(String searchTerm){
    searchField.sendKeys(searchTerm);
    searchField.sendKeys(Keys.ENTER);
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    return new SearchPage(driver);//создание объекта новой страницы
    }
}
