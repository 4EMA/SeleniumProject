package day9.homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class SignUpFormSubmissionParsing {
    /**
     * open SignUpForm.html
     * fill in your data inside the all input elements
     * submit the form
     * get URL
     * parse values that was submitted and print them out
     */
    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "/Applications/technostudy/Selenium/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("file:///Users/mahiyebarutcu/IdeaProjects/SeleniumProject/src/day9/homework1/SignUpForm.html");
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
        String url = driver.getCurrentUrl();
        System.out.println(url);
        parseUrl(driver, url);

    }

    private static void parseUrl(WebDriver driver, String url) throws MalformedURLException {
        URL myUrl = new URL(url);
        String sentKeys = myUrl.getQuery();
        for (String str : sentKeys.split("&")) {
            System.out.println(str);

        }
    }
}