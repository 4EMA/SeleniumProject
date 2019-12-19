package day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ex {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Applications/technostudy/Selenium/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:63342/selenium/day2/resources/Practice.html?_ijt=ers7v35enqerf18k6ev6e0h37h");


    }
}
