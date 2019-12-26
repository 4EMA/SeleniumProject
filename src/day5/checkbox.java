package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class checkbox {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Applications/technostudy/Selenium/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        List<WebElement> uncheckedBoxes = driver.findElements( By.cssSelector( ".cb1-element:not(:checked)" ) );
        int sizeBefore = uncheckedBoxes.size();

        driver.findElement( By.id( "check1" ) ).click();

        List<WebElement> checkedBoxes = driver.findElements( By.cssSelector( ".cb1-element:checked" ) );
        int sizeAfter = checkedBoxes.size();

        if(sizeBefore == sizeAfter) {
            System.out.println("Success!");
        } else {
            System.out.println("Failure!");
        }
    }
}
