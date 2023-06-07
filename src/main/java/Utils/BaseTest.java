package Utils;

import org.testng.annotations.BeforeSuite;

public class BaseTest {
    @BeforeSuite
    public void beforeMethod() {
        WebDriverProvider.setupDriver();
    }

}
