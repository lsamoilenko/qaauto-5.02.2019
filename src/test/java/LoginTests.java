import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{

    @DataProvider
    public Object[][] ValidDataProvider() {
        return new Object[][]{
                {"baddy@i.ua","Qwerty123"},
                //{"baDDY@i.ua","Qwerty123"},
               // {" baddy@i.ua ","Qwerty123"}
        };
    }
    @Test(dataProvider = "ValidDataProvider")
    public void successfulLoginTest(String userEmail, String userPassword) {
        Assert.assertTrue(landingPage.isPageloaded(),"Landing page is not loaded.");

        HomePage homePage=landingPage.login(userEmail, userPassword, HomePage.class);//pattern

        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded.");
    }


    @DataProvider
    public Object[][] invalidData() {
        return new Object[][]{
                {"baddy@i.ua","0","", "Hmm, that's not the right password. Please try again or request a new one."},
                //{"!@#$%^&*()","1","Be sure to include \"+\" and your country code.", ""},
                //{"+-","2","Please enter a valid email address.", ""}
        };
        }

    @Test(dataProvider = "invalidData")

    public void negativLoginTest(String userEmail, String userPassword, String emailValidationMessage, String passwordValidationMessage) {

        Assert.assertTrue(landingPage.isPageloaded(), "Landing page is not loaded.");

        LoginSubmitPage loginSubmitPage = landingPage.login(userEmail, userPassword);

        //LoginSubmitPage loginSubmitPage = landingPage.loginToLoginSubmit(userEmail, userPassword);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(), "Login submit page is not loaded.");

        Assert.assertEquals(loginSubmitPage.getUserEmailValidationText(), emailValidationMessage, "userEmail validation message text is wrong");
        Assert.assertEquals(loginSubmitPage.getUserPasswordValidationText(), passwordValidationMessage,
                "userPassword validation message text is wrong");
    }
}
