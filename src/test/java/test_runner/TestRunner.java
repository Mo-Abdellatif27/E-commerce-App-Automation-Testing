package test_runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src\\main\\resources\\features"},
        glue = "step_definitions",
        plugin = {"pretty", "html:src/cucumber"},
        tags = "@SmokeTesting"
)

public class TestRunner extends AbstractTestNGCucumberTests {
}
