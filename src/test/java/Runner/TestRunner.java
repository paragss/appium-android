package Runner;

import Hooks.Hooks;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"stepDefinitions", "StepDefinition"},
        tags = "@RunAll",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true

)
public class TestRunner extends AbstractTestNGCucumberTests {
    public static Hooks hooks = new Hooks();

    @BeforeSuite
    public void startServer() {
        hooks.startAppium();
    }

    @AfterSuite
    public void stopServer() {
       hooks.stopAppium();
    }

}
