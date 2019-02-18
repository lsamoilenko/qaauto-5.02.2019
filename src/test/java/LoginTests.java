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

    /*@AfterMethod
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

       /* WebElement userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        userEmailField.sendKeys("sln86@i.ua");
        userPasswordField.sendKeys("Qwerty123");
        signInButton.click();

        WebElement profileMenuItem = driver.findElement(By.xpath("//li[@id='profile-nav-item']"));

        profileMenuItem.isDisplayed();
        Assert.assertTrue(profileMenuItem.isDisplayed(),
                "profileMenuItem is not displayed on Home page.");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.linkedin.com/feed/",
                "Home page URL is incorrect.");
        }*/

        @Test
        public void wrongPasswordTest(){

            WebElement userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
            WebElement userPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));
            WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

            userEmailField.sendKeys("sln86@i.ua");
            userPasswordField.sendKeys("0");
            signInButton.click();

            WebElement msg = driver.findElement(By.xpath("//div[@id='error-for-password']"));
            String wrongPasswordMessage = msg.getText();

            WebElement errorPage = driver.findElement(By.xpath("//main[@class='app__content']"));
            
            System.out.println(wrongPasswordMessage);
            errorPage.isDisplayed();

            Assert.assertEquals(wrongPasswordMessage,
                    "Hmm, that's not the right password. Please try again or request a new one.",
                    "wrongPasswordMessage is incorrect");
            Assert.assertEquals(driver.getCurrentUrl(),"https://www.linkedin.com/uas/login-submit?loginSubmitSource=GUEST_HOME",
                    "Error page URL is incorrect.");
        }

    @Test
    public void wrongLoginTest(){

        WebElement userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        userEmailField.sendKeys("!@#$%^&*()");
        userPasswordField.sendKeys("1");
        signInButton.click();

        WebElement msg = driver.findElement(By.xpath("//div[@id='error-for-username']"));
        String wrongLoginMessage = msg.getText();

        WebElement errorPage = driver.findElement(By.xpath("//main[@class='app__content']"));

        System.out.println(wrongLoginMessage);
        errorPage.isDisplayed();

        Assert.assertEquals(wrongLoginMessage,
                "Be sure to include \"+\" and your country code.",
                "wrongLoginMessage is incorrect");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.linkedin.com/uas/login-submit?loginSubmitSource=GUEST_HOME",
                "Error page URL is incorrect.");
    }
}

