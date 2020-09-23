package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/Feature"
        ,glue={"src/main/stepDefinition"}
)

public class TestRunner extends AbstractTestNGCucumberTests { }