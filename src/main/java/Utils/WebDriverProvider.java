package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ThreadGuard;

import java.time.Duration;
import java.util.Objects;

public class WebDriverProvider {
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    private static String getBrowserName() {
        return ConfigProperties.getProperties().get("browserName").toString();
    }

    public static void setupDriver() {
        String browserName = getBrowserName();
        System.out.println(browserName);
        if (Objects.equals(browserName, "chrome") && Objects.isNull(DRIVER.get())) {
            DRIVER.set(ThreadGuard.protect(new ChromeDriver()));
            setBrowserOptions();
        } else if (Objects.equals(browserName, "firefox") && Objects.isNull(DRIVER.get())) {
            DRIVER.set(ThreadGuard.protect(new FirefoxDriver()));
            setBrowserOptions();
        }
    }

    public static void setBrowserOptions() {
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static WebDriver getDriver() {
        if (Objects.isNull(DRIVER.get())) {
            setupDriver();
        }
        return DRIVER.get();
    }
}
