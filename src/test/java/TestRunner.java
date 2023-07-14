import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(

        tags = "@RandstadTest",

        features = "classpath:features", glue = { "cucumberFeatures",},

        plugin = { "pretty", "json:target/cucumber-reports/cucumber.json",
                "html:target/cucumber-reports/cucumberreport.html"},
        monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {

}
