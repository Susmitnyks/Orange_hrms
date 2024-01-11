package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class loginpage extends basepage{
    String hrm_url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    String username="//input[@name='username']";
    String password="//input[@name='password']";
    String submit="//button[text()=' Login ']";
    String dashboard="//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6";
    public void launch()
    {
        driver.manage().window().maximize();
        driver.get(hrm_url);
    }

   public void usr_pass()
    {
        explicitWait(driver,username, Duration.ofSeconds(10));
        sendKeys("Admin",username);
        sendKeys("admin123",password);
    }

    public void submit_btn()
    {
        click(submit);
    }

    public void verifyHomepage() throws InterruptedException {
        explicitWait(driver,dashboard,Duration.ofSeconds(4));
        String db=driver.findElement(By.xpath(dashboard)).getText();
        Assert.assertEquals("Dashboard",db);
    }


}
