package Test;

import Utils.BaseTest;
import Utils.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class RanstadTest extends BaseTest {


    @Test
    public void goToRandstad() {
        WebDriverProvider.getDriver().get("https://www.randstad.pl/");
        WebElement cookieAcceptButton = getWebEelement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        cookieAcceptButton.click();
        firstColumnCheck();
    }
    public void firstColumnCheck() {
        List<WebElement> list = getWebEelements(By.xpath("//ul[@class='navigation__menu navigation__menu--sub hidden--until-l']//a"));
        for (int i = 1; i <= list.size(); i++) {
            {
                String xpath = String.format("(//ul[@class='navigation__menu navigation__menu--sub hidden--until-l']//a)[%d]", i);
                WebElement element = getWebEelement(By.xpath(xpath));
                String name = element.getText();
                element.click();
                String url = WebDriverProvider.getDriver().getCurrentUrl();
                System.out.println("nazwa podstrony: " + name + " " + "Url podstrony: " + url);
                WebDriverProvider.getDriver().navigate().back();
            }
        }
    }
}
