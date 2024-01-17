package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import pages.loginpage;
import pages.myinfopage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyStepdefs {
    WebDriver driver = new ChromeDriver();
    loginpage lp = new loginpage(driver);
    myinfopage info = new myinfopage(driver);

    @Given("User is on the login page")
    public void userIsOnTheLoginPage() {
        lp.launch();
    }

    @When("User enters username and password")
    public void userEntersUsernameAndPassword() {
        lp.usr_pass();
    }

    @And("User clicks on the submit button")
    public void userClicksOnTheSubmitButton() {
        lp.submit_btn();
    }

    @Then("User is navigated to home page")
    public void userIsNavigatedToHomePage() throws InterruptedException, IOException {
        lp.verifyHomepage_login();
    }

    @Given("User is logged in into application")
    public void userIsLoggedInIntoApplication() throws InterruptedException, IOException {
        lp.launch();
        lp.usr_pass();
        lp.submit_btn();
        lp.verifyHomepage_login();
    }

    @When("User clicks on logout button")
    public void userUserClicksOnLogoutButton() {
        lp.log_out();
    }

    @Then("User is navigated back to login screen")
    public void userIsNavigatedBackToLoginScreen() {
        lp.verify_homepage_logout();
    }

    @Given("User is on the My info page")
    public void userIsOnTheMyInfoPage() throws InterruptedException {
        lp.launch();
        lp.usr_pass();
        lp.submit_btn();
        info.myinfo_click();
    }

    @When("User clicks on the profile picture and clicks on + icon and Upload profile picture")
    public void userClicksOnTheProfilePictureAndClicksOnIconAndUploadProfilePicture() throws InterruptedException, FindFailed, IOException {
     info.upload_pic();
    }


    @When("User will enters {string} and {string}")
    public void userWillEntersAnd(String username, String password) {
     lp.usr_pass_outline(username,password);
    }

    @Then("User lands on the homepage")
    public void userLandsOnTheHomepage() throws IOException, InterruptedException {
        lp.verifyHomepage_login();
    }

    @And("User do logout")
    public void userDoLogout() {
        lp.log_out();
    }
}
