import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@id='login-email']")
    private WebElement userEmailField;

    @FindBy(xpath = "//input[@id='login-password']")
    private WebElement userPasswordField;

    @FindBy(xpath = "//input[@id='login-submit']")
    private WebElement signInButton;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);//читаем из landing page//пейдж фектори используется для считываения элементов и использования их в нужное время
    }

    public <GenericPage> GenericPage login(String userEmail, String userPassword) {//GenericPage = T//для приведения лендиен пейдж и хоум пейдж к одному типу данных
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        if (driver.getCurrentUrl().contains("/feed")) {
            return (GenericPage) new HomePage(driver);//вызываем новый объект конструктор класса xoум пейдж
            //return (GenericPage) PageFactory.initElements(driver, HomePage.class);//строка создает новый объект хоумпейдж, заходит в конструктор
        } else {
            return (GenericPage) new LoginSubmitPage(driver);

        }
    }

    public <ExpectedPage> ExpectedPage login(String userEmail, String userPassword, Class<ExpectedPage> expectedPage){
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        return PageFactory.initElements(driver, expectedPage);
    }

 /*   public HomePage login(String userEmail, String userPassword){
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        return new HomePage(driver);
    }

    public LoginSubmitPage loginToLoginSubmit(String userEmail, String userPassword) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        return new LoginSubmitPage(driver);
    }*/

    public boolean isPageloaded() {
        return signInButton.isDisplayed()
                && driver.getCurrentUrl().equals("https://www.linkedin.com/")
                && driver.getTitle().equals("LinkedIn: Log In or Sign Up");
    }

}
