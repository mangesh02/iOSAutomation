package automation.suite;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "json:target/cucumber.json" }, glue = { "automation.stepdefs",
		"browsers" }, features = "src/test/resources/features",
		monochrome = true)//, tags = {"@AndroidBrowser","~@AndroidApp","~@IOSBrowser","~@IOSApp"}
public class RunWIPCukes {

}
