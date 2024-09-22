package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/java/Cucumber",
    glue = "RahulShetty.stepDefinations",
    plugin = {"pretty", "html:target/cucumber-html-report.html", "json:target/cucumber.json"},
    monochrome = true, tags="Regression"
)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
    // No additional code needed here
}