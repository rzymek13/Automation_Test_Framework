package Test;

import Utils.WebDriverProvider;
import org.testng.annotations.Test;

public class FirstTest {

   @Test
    public void goToRandstad() {
       WebDriverProvider.setupDriver();
       WebDriverProvider.getDriver().get("https://www.randstad.pl/");
    }
    @Test
    public void goToGoogle() {
        WebDriverProvider.setupDriver();
        WebDriverProvider.getDriver().get("https://www.google.pl/");
    }
    @Test
    public void goToAmazon() {
        WebDriverProvider.setupDriver();
        WebDriverProvider.getDriver().get("https://www.amazon.com/");
    }
}
