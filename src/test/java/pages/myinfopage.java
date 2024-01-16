package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

import java.io.IOException;

public class myinfopage extends basepage{
    String Prof_img="//img[@alt='profile picture' and @class='employee-image']";
    String plus_button="//button[@class='oxd-icon-button oxd-icon-button--solid-main employee-image-action']";
    String save_btn="//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']";

    public myinfopage(WebDriver driver) {
        super(driver); // calls constructor of super class.
    }

    String myinfo_menu="//*[@class=\"oxd-text oxd-text--span oxd-main-menu-item--name\" and text()='My Info']";

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
        driver.findElement(By.xpath(save_btn)).click();


    }

}
