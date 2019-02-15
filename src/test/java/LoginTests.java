import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\samoilenko_l\\IdeaProjects\\qaauto-5.02.2019\\chromedriver.exe");
        driver = new ChromeDriver();//запуск приложения chromedriver, открывется новое окно браузера
        driver.get("http://www.linkedin.com");
    }

    @AfterMethod
    public void afterMethod (){
        driver.quit();
    }
    @Test
    public void successfulLoginTest() {

       /* WebElement email = driver.findElement(By.xpath("//input[@id='login-email']"));
        email.sendKeys("ludalm41@i.ua");
        WebElement password = driver.findElement(By.xpath("//input[@id='login-password']"));
        password.sendKeys("e1dk99");
        driver.findElement(By.xpath("//input[@id='login-submit']")).click();
        driver.findElement(By.xpath("//img[@alt='mila mila']")).click();*/

        WebElement userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        userEmailField.sendKeys("ludalm41@i.ua");
        userPasswordField.sendKeys("e1dk99");
        signInButton.click();

        WebElement profileMenuItem = driver.findElement(By.xpath("//li[@id='profile-nav-item']"));

        profileMenuItem.isDisplayed();
        Assert.assertTrue(profileMenuItem.isDisplayed(),
                "profileMenuItem is not displayed on Home page.");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.linkedin.com/feed/",
                "Home page URL is incorrect.");
        }

        @Test
        public void negativeLoginTest(){

        }
}
