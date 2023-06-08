package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;


import java.util.List;

public class BaseTest {
    @BeforeSuite
    public void beforeMethod() {
        WebDriverProvider.setupDriver();
    }

    public WebElement getWebEelement(By by) {
        try {
            return WebDriverProvider.getDriver().findElement(by);
        } catch (StaleElementReferenceException e) {
            return WebDriverProvider.getDriver().findElement(by);
        }
    }

    public List<WebElement> getWebEelements(By by) {
        return WebDriverProvider.getDriver().findElements(by);
    }

}
