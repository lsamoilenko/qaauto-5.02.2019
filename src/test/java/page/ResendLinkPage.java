package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ResendLinkPage {
    private WebDriver driver;

    @FindBy(xpath = "//button[@id='resend-url']")
    private WebElement resentLinkBotton;


    public ResendLinkPage(WebDriver driver) {//конструктор класса forgot pwd
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return resentLinkBotton.isDisplayed()
                && driver.getCurrentUrl().contains("https://www.linkedin.com/checkpoint/rp/request-password-reset-submit");
    }

}
