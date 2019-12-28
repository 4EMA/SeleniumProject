package day9.homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class SignUpFormSubmissionValidation {
    /**
     * open SignUpForm.html
     * store values that you will use inside some Strings
     * fill in your data inside the all input elements using Strings above
     * submit the form
     * get URL
     * parse values that was submitted
     * validate parsed values with stored values above
     */
    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "/Applications/technostudy/Selenium/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("file:///Users/mahiyebarutcu/IdeaProjects/SeleniumProject/src/day9/homework1/SignUpForm.html");
        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.name("username"));
        String myUsername = "Ema";
        username.sendKeys(myUsername);

        WebElement password = driver.findElement(By.name("password"));
        String myPassword = "1868";
        password.sendKeys(myPassword);

        WebElement repeatPassword = driver.findElement(By.name("passwordRpt"));
        repeatPassword.sendKeys(myPassword);

        WebElement address = driver.findElement(By.name("address"));
        String myAddress = "600 Getty Ave, Clifton, USA 00000";
        address.sendKeys(myAddress);

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
        parseUrl(driver, url);

        if (url.contains(myUsername)) {
            System.out.println("username: success");
        }
        if (url.contains(myPassword)) {
            System.out.println("password: success");
        }
        if (url.contains(myAddress.substring(0, 3))) {
            System.out.println("address: success");
        } else
            System.out.println("fail!");

        Thread.sleep(2000);
        driver.quit();
    }

    private static void parseUrl(WebDriver driver, String url) throws MalformedURLException {
        URL myUrl = new URL(url);
        String sentKeys = myUrl.getQuery();
        for (String str : sentKeys.split("&")) {
            System.out.println(str);
        }
    }
}