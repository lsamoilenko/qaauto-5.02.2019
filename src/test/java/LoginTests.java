import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTests {

    @Test
    public void successfulLoginTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\samoilenko_l\\IdeaProjects\\qaauto-5.02.2019\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();//запуск приложения chromedriver, открывется новое окно браузера
        driver.get("http://www.linkedin.com");
        WebElement email = driver.findElement(By.xpath("//input[@id='login-email']"));
        email.sendKeys("ludalm41@i.ua");
        WebElement password = driver.findElement(By.xpath("//input[@id='login-password']"));
        password.sendKeys("e1dk99");
        driver.findElement(By.xpath("//input[@id='login-submit']")).click();
        driver.findElement(By.xpath("//img[@alt='mila mila']")).click();
        }
}
