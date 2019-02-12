import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.util.List;


public class BadCodeExample {
    public static void main(String[] args) {
        System.out.println("Hello World!!");

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\samoilenko_l\\IdeaProjects\\qaauto-5.02.2019\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();//запуск приложения chromedriver, открывется новое окно браузера
        driver.get("http://www.google.com");
        //1st way
        //WebElement element = driver.findElement(By.name("q"));
        //element.sendKeys("Selenium");
        //element.submit();
        //2nd way
        String searchTerm = "Selenium";
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);

        List<WebElement> searchResultElements = driver.findElements(By.xpath("//div[@class='g']"));
        System.out.println("Results count:" + searchResultElements.size());

        //Loop through every element in searchResultElements list
        //1st way
        //List<WebElement> sectionList=driver.findElements(By.xpath("//div[@class='g']"));
        //int i=0;
        //for(WebElement element:sectionList){
        //System.out.println("Section "+i+":"+element.getText());//print text of each element
        //i++;

        //2nd way
        //Loop through every element in searchResultElements list
        /*for ( WebElement eachResult: searchResultElements){
        System.out.println(eachResult.getText());

        if(eachResult.getText().toLowerCase().contains("SELEnium".toLowerCase()))

        {
            System.out.println("searchTerm found");//print "searchTerm found" if "Selenium" is present in element
        }else{
            System.out.println("searchTerm not found");//print "searchTerm not found" if "Selenium" is not present in element
             }
       }*/
        //3d way
        //For each WebElement in searchResultElements print text
        for (WebElement searchResultElement : searchResultElements) {
            String searchResultElementText = searchResultElement.getText();
            System.out.println(searchResultElementText);
            if (searchResultElementText.toLowerCase().contains(searchTerm.toLowerCase())) {
                System.out.println("searchTerm found");
            } else {
                System.out.println("searchTerm not found");
            }
        }
    }
}

