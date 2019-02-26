import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\samoilenko_l\\IdeaProjects\\qaauto-5.02.2019\\chromedriver.exe");
        driver = new ChromeDriver();//запуск приложения chromedriver, открывется новое окно браузера
        driver.get("http://www.linkedin.com");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @DataProvider
    public Object[][] ValidDataProvider() {
        return new Object[][]{
                {"milesla@i.ua","Qwerty123"},
                {"milesLA@i.ua","Qwerty123"},
                {" milesla@i.ua ","Qwerty123"}
        };
    }
    @Test(dataProvider = "ValidDataProvider")
    public void successfulLoginTest(String userEmail, String userPassword) {
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageloaded(),"Landing page is not loaded.");

        landingPage.login(userEmail, userPassword);

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded.");
    }


    @DataProvider
    public Object[][] InvalidDataProvider() {
        return new Object[][]{
                {"milesla@i.ua","0","", "Hmm, that's not the right password. Please try again or request a new one."},
                {"!@#$%^&*()","1","Be sure to include \"+\" and your country code.", ""},
                {"+-","2","Please enter a valid email address.", ""}
        };
        }

    @Test(dataProvider = "InvalidDataProvider")

    public void negativLoginTest(String userEmail, String userPassword, String emailValidationMessage, String passwordValidationMessage) {
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageloaded(), "Landing page is not loaded.");

        landingPage.login(userEmail, userPassword);

        LoginSubmitPage loginSubmitPage = new LoginSubmitPage(driver);
       Assert.assertTrue(loginSubmitPage.isPageLoaded(), "Login submit page is not loaded.");

        Assert.assertEquals(loginSubmitPage.wrongEmailMessage.getText(), emailValidationMessage, "Invalid login");
        Assert.assertEquals(loginSubmitPage.wrongPasswordMessage.getText(), passwordValidationMessage, "Invalid password");
    }
}
