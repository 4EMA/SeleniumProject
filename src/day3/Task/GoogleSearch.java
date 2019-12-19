package day3.Task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Applications/technostudy/Selenium/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get( "https://www.google.com" );

        WebElement element = driver.findElement( By.name( "q" ) );
        element.sendKeys( "TechnoStudy" );
        element.submit();
    }
}



