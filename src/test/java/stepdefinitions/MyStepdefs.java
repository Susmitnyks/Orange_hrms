package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.loginpage;

public class MyStepdefs {
    loginpage lp=new loginpage();
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
        lp.submit();
    }

    @Then("User is navigated to home page")
    public void userIsNavigatedToHomePage() throws InterruptedException {
        lp.verifyHomepage();
    }
}
