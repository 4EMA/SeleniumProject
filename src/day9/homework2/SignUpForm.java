package day9.homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SignUpForm {
    /**
     * open SignUpForm.html
     * fill in your data inside the all input elements
     */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/technostudy/Selenium/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("file:///Users/mahiyebarutcu/IdeaProjects/SeleniumProject/src/day9/homework1/SignUpForm.html");
        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Ema");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("1868");

        WebElement repeatPassword = driver.findElement(By.name("passwordRpt"));
        repeatPassword.sendKeys("1868");

        WebElement address = driver.findElement(By.name("address"));
        address.sendKeys("600 Getty Ave" + "\n" + "Clifton, USA ");

        List<WebElement> gender = driver.findElements(By.name("sex"));
        gender.get(0).click();

        WebElement plan = driver.findElement(By.name("plan"));
        Select p = new Select(plan);
        int planSize = driver.findElements(By.tagName("option")).size();
        for (int i = 0; i < planSize; i++) {
            Thread.sleep(1000);
            p.selectByIndex(i);
        }

        WebElement agree = driver.findElement(By.name("agreement"));
        agree.click();

        Thread.sleep(5000);

        WebElement submit = driver.findElement(By.name("submit"));
        submit.click();
        // page will renew after submission

        Thread.sleep(2000);
        driver.quit();
    }
}

