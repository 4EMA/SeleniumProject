package day9.homework4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElementVisibilityWithError {
    /**
     * Open "http://the-internet.herokuapp.com/dynamic_controls"
     * <p>
     * click on "Remove" button
     * wait for checkbox to disappear within 2 seconds
     * if checkbox does not disappear print failure
     * if test fails take a screenshot and store inside homework4 folder
     **/
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Applications/technostudy/Selenium/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ultimateqa.com/filling-out-forms/");
        driver.manage().window().maximize();

        driver.manage().window().maximize();

        WebElement remove = driver.findElement(By.xpath("//form[@id='checkbox-example']/button"));
        remove.click();

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='checkbox-example']/p")));
        if (driver.findElement(By.xpath("//form[@id='checkbox-example']/p")).getText().equalsIgnoreCase("it's gone!")) {
            System.out.println("remove message: success");
        } else {
            System.out.println("remove message: failure");
        }
    }
}
