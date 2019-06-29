package autotest;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Gmail {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\Gecko\\geckodriver.exe");
        WebDriver driver;
        driver = new FirefoxDriver();
        String url = ("https://www.gmail.com");
        driver.get(url);
        System.out.println("Successfully opened the website localhost");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement email_phone = driver.findElement(By.xpath("//input[@id='identifierId']"));
        email_phone.sendKeys("your email");
        driver.findElement(By.id("identifierNext")).click();
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        WebDriverWait wait = new WebDriverWait(driver, 18);
        wait.until(ExpectedConditions.elementToBeClickable(password));
        password.sendKeys("your password");
        driver.findElement(By.id("passwordNext")).click();
        List<WebElement> unreademail = driver.findElements(By.className("zE"));
        System.out.println("Total No. of Unread Mails: " + unreademail.size());
    }
}
