package Test;

import Utils.BaseTest;
import Utils.WebDriverProvider;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {



    @Test
    public void goToRandstad() {
       WebDriverProvider.getDriver().get("https://www.randstad.pl/");
    }
    @Test
    public void goToGoogle() {
        WebDriverProvider.getDriver().get("https://www.google.pl/");
    }
    @Test
    public void goToAmazon() {
        WebDriverProvider.getDriver().get("https://www.amazon.com/");
    }
}
