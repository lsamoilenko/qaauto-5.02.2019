package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;


public class ForgotPasswordPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[contains(@placeholder, 'Enter your email or phone')]")
    private WebElement emailPhoneField;

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement findAccountButton;


    public ForgotPasswordPage(WebDriver driver) {//конструктор класса forgot pwd
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return emailPhoneField.isDisplayed()
                && driver.getCurrentUrl().contains("https://www.linkedin.com/uas/request-password-reset?trk=uno-reg-guest-home-forgot-password");
    }

    public ResendLinkPage inputEmail(String email){
        emailPhoneField.sendKeys(email);
        //findAccountButton.click();

        String messageSubject = "here's the link to reset your password";
        String messageTo = email;
        String messageFrom = "security-noreply@linkedin.com";

        GMailService gMailService = new GMailService();
        gMailService.connect();
        findAccountButton.click();

        String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 180);
        System.out.println("Content: " + message);

        return new ResendLinkPage(driver);
    }
}
