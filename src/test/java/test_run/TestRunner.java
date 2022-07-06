package test_run;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src\\main\\resources\\features"},
        glue = {"stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber"},
        tags = "@SmokeTesting"
)

public class TestRunner extends AbstractTestNGCucumberTests {
    public TestRunner() {
    }
}
