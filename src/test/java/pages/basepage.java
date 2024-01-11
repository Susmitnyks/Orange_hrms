package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class basepage {
    WebDriver driver=new ChromeDriver();

    // common sendkeys method
    public void sendKeys(String text,String xp)
    {
        driver.findElement(By.xpath(xp)).sendKeys(text);
    }

    // Common Click method
    public void click(String xp)
    {
        driver.findElement(By.xpath(xp)).click();
    }

    // common explicit wait
    public static void explicitWait(WebDriver driver, String xpath, Duration timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("Timed out waiting for element with XPath: " + xpath);
        }
    }
}
