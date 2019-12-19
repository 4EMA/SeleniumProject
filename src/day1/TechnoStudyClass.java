package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TechnoStudyClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Applications/technostudy/Selenium/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.techno.study");

        List<WebElement> links = driver.findElements(By.tagName("a"));

        for (WebElement link : links) {
            System.out.println(link.getAttribute("href"));
            System.out.println(link.getAttribute("class"));


        }


    }
}
