package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.List;


public class BaseTest {
    @BeforeSuite
    public void beforeMethod() {
        WebDriverProvider.setupDriver();
    }

    public WebElement getWebEelement(By by) {
        waitForElementToExist(by);
            return WebDriverProvider.getDriver().findElement(by);

    }

    public List<WebElement> getWebEelements(By by) {
        return WebDriverProvider.getDriver().findElements(by);
    }
    public void waitForElementToExist(By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(WebDriverProvider.getDriver());
        wait.ignoring(StaleElementReferenceException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.until(driver -> {
                List<WebElement> elements = getWebEelements(locator);
                if (elements.size()>0) {
                    return true;
                } else {
                    return false;
                }
        });
    }
}
