import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSubmitPage {
        WebDriver driver;

        WebElement wrongPasswordMessage;
        WebElement loginSubmitPage;

        public LoginSubmitPage(WebDriver driver) {
            this.driver = driver;
            initElements();
        }

        public void initElements(){
            wrongPasswordMessage = driver.findElement(By.xpath("//div[@id='error-for-password']"));
            loginSubmitPage = driver.findElement(By.xpath("//main[@class='app__content']"));
        }

}