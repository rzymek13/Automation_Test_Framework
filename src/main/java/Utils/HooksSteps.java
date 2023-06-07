package Utils;

import org.testng.annotations.BeforeSuite;

public class HooksSteps {

    @BeforeSuite
    public void beforeMethod() {
        WebDriverProvider.setupDriver();
    }
}
