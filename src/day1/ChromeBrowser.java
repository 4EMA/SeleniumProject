package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ChromeBrowser {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Applications/technostudy/Selenium/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get ("https://www.techno.study");




	// write your code here
    }
}
