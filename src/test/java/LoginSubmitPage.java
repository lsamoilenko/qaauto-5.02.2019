import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSubmitPage {
        WebDriver driver;

        WebElement loginSubmitPage;
        WebElement wrongEmailMessage;
        WebElement wrongPasswordMessage;


        public LoginSubmitPage(WebDriver driver) {
            this.driver = driver;
            initElements();
        }

        public void initElements(){
            loginSubmitPage = driver.findElement(By.xpath("//main[@class='app__content']"));
            wrongEmailMessage = driver.findElement(By.xpath("//div[@id='error-for-username']"));
            wrongPasswordMessage = driver.findElement(By.xpath("//div[@id='error-for-password']"));
        }

        public boolean isPageLoaded() {
        return driver.getCurrentUrl().contains("login-submit")
               && loginSubmitPage.isDisplayed()
                && wrongEmailMessage.isDisplayed()
                || wrongPasswordMessage.isDisplayed();
        }


}