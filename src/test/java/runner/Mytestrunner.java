package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions"},
        /*monochrome = true,
        tags = ("@Login_test_case"),
        dryRun = false,*/
        plugin = {"pretty","html:target/cucumber-html-report","json:cucumber.json" }
)
public class Mytestrunner {
}
