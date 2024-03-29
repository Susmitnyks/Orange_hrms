package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.python.antlr.ast.Str;
import org.python.modules._threading._threading;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

import java.io.IOException;

public class myinfopage extends basepage{
    String fname_field="//input[@class='oxd-input oxd-input--active oxd-input--error orangehrm-firstname']";
    String lname_field="//input[@class='oxd-input oxd-input--active oxd-input--error orangehrm-lastname']";
    String fname="//input[@class='oxd-input oxd-input--active orangehrm-firstname']";
    String fname_value=getcell(0,0);
    String lname_value=getcell(0,1);
    String lname="//input[@class='oxd-input oxd-input--active orangehrm-lastname']";
    String succes_msg="//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']";

    String Prof_img="//img[@alt='profile picture' and @class='employee-image']";
    String plus_button="//button[@class='oxd-icon-button oxd-icon-button--solid-main employee-image-action']";
    String save_btn="//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']";
    String country=getcell(0,2);
    String country_xpath="//div[@class='oxd-select-option' and span[text()='"+country+"']]";
    String birthdate_field="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[2]/div[1]/div/div[2]/div/div/input";
    public myinfopage(WebDriver driver) throws IOException {
        super(driver); // calls constructor of super class.
    }

    String myinfo_menu="//*[@class=\"oxd-text oxd-text--span oxd-main-menu-item--name\" and text()='My Info']";

    String nationality_drp="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[1]/div/div[2]/div/div/div[2]/i";
    public void myinfo_click() throws InterruptedException {
        Thread.sleep(4000);
        driver.findElement(By.xpath(myinfo_menu)).click();
    }

    public void upload_pic() throws InterruptedException, FindFailed, IOException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Prof_img)).click();
        Thread.sleep(2000);
        WebElement addfile= driver.findElement(By.xpath(plus_button));
        addfile.click();
        Thread.sleep(4000);
        Runtime.getRuntime().exec("C:\\Users\\SusmitSurwade\\Documents\\file.exe");
        Thread.sleep(2000);
        driver.findElement(By.xpath(save_btn)).click();
    }

    public void update_details() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(fname)).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        driver.findElement(By.xpath(lname)).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        Thread.sleep(2000);
        driver.findElement(By.xpath(fname_field)).sendKeys(fname_value);
        driver.findElement(By.xpath(lname_field)).sendKeys(lname_value);
    }

    public void verify_success_msg()
    {
       explicit_wait(succes_msg);
       WebElement msg=driver.findElement(By.xpath(succes_msg));
       Assert.assertTrue(msg.isDisplayed());
    }

    public void birth_date() throws InterruptedException, IOException {
        Thread.sleep(1000);
        driver.findElement(By.xpath(birthdate_field)).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        driver.findElement(By.xpath(birthdate_field)).sendKeys(getcell(0,3));
    }

    public void nation() throws InterruptedException, IOException {
        Thread.sleep(1000);
        dropdown_list(nationality_drp,country_xpath);
        driver.findElement(By.xpath(save_btn)).click();
    }

}
