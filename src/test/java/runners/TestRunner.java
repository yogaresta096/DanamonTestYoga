package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepsdefinitions",
        plugin = {"pretty", "html:target/reports/cucumber-reports.html"}
)
public class TestRunner {
}
