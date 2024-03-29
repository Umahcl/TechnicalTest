package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//To integrate cucumber with TestNG

@CucumberOptions(features = "./src/test/java/Feature/Purchase.feature", plugin = { "pretty",
		"html:target/CucumberReports",
		"json:target/cucumber-report.json" }, strict = false, monochrome = true, glue = "steps")

public class RunTest extends AbstractTestNGCucumberTests {

}