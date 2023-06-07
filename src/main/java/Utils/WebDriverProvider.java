package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.annotations.BeforeMethod;

import java.util.Objects;

public class WebDriverProvider {
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    private static String getBrowserName() {
        return ConfigProperties.getProperties().get("browserName").toString();
    }

    @BeforeMethod
    public static void setupDriver() {
        String browserName = getBrowserName();
        System.out.println(browserName);
        if (Objects.equals(browserName, "chrome") && Objects.isNull(DRIVER.get())) {
            DRIVER.set(ThreadGuard.protect(new ChromeDriver()));
        } else if (Objects.equals(browserName, "firefox") && Objects.isNull(DRIVER.get())) {
            DRIVER.set(ThreadGuard.protect(new FirefoxDriver()));
        }
    }

    public static WebDriver getDriver() {
        return DRIVER.get();
    }
}
