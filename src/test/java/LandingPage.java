import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    private WebDriver driver;

    private WebElement userEmailField;
    private WebElement userPasswordField;
    private WebElement signInButton;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements(){
        userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        userPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));
    }

    public void login(String userEmail, String userPassword){
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
    }

    public boolean isPageloaded() {
        return signInButton.isDisplayed()
                && driver.getCurrentUrl().equals("https://www.linkedin.com/")
                && driver.getTitle().equals("LinkedIn: Log In or Sign Up");
    }

}
