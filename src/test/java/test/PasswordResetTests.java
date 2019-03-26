package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.ForgotPasswordPage;
import page.ResendLinkPage;


public class PasswordResetTests extends BaseTest {

    @Test

    public void successfulPasswordResetTest() {
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        ForgotPasswordPage forgotPasswordPage = landingPage.forgotPassword();
        Assert.assertTrue(forgotPasswordPage.isPageLoaded(), "Forgot password page is not loaded.");

        String email = "kir00plast@gmail.com";
        ResendLinkPage resendLinkPage = forgotPasswordPage.inputEmail(email);
        //Assert.assertTrue(resendLinkPage.isPageLoaded(), "Resend Link page is not loaded.");

    }
}