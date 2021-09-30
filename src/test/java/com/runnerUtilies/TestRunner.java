

package com.runnerUtilies;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
        features = "src/test/resources/features",
        glue = {"com/steps"},
        plugin = {"pretty", "html:test-output", "json:target/cucumber.json","html:target/cucumber.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "@SmokeTest",
        monochrome = true

)

public class TestRunner {


}
