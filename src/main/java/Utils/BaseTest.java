package Utils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    @BeforeMethod
    public void beforeMethod() {
        WebDriverProvider.setupDriver();
    }

}
