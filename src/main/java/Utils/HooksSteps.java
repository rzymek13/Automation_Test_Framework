package Utils;

import org.testng.annotations.BeforeMethod;

public class HooksSteps {

    @BeforeMethod
    public void beforeMethod() {
        WebDriverProvider.setupDriver();
    }
}
