package Test;

import Utils.BaseTest;
import Utils.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class RanstadTest extends BaseTest {

    private static final String FILE_PATH = "src/test/java/Test/dataFiles/RandstadPL.xlsx";


    public static void randstadTestPl() {
        WebDriverProvider.getDriver().get("https://www.randstad.pl/");
        acceptCookies();
        clickAllNavBarLinks();
        compareLinksFromFile();
    }

    public static void acceptCookies() {
        WebElement cookieAcceptButton = getWebEelement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        cookieAcceptButton.click();
    }

    public static void clickFirstColumnLinks() {
        List<WebElement> list = getWebEelements(By.xpath("//ul[@class='navigation__menu navigation__menu--sub hidden--until-l']//a"));
        for (int i = 1; i <= list.size(); i++) {
            String xpath = String.format("(//ul[@class='navigation__menu navigation__menu--sub hidden--until-l']//a)[%d]", i);
            WebElement element = getWebEelement(By.xpath(xpath));
            String name = element.getText();
            element.click();
            String url = WebDriverProvider.getDriver().getCurrentUrl();
            SiteData siteData = new SiteData(name, url);
            SiteData.lista.add(siteData);
        }
    }

    public static void clickAllNavBarLinks() {
        List<WebElement> navBarList = getWebEelements(By.xpath("//ul[@class='navigation__menu navigation__menu--main hidden--until-l']/li"));
        for (int i = 1; i <= navBarList.size(); i++) {
            String xpath = String.format("(//ul[@class='navigation__menu navigation__menu--main hidden--until-l']/li/a)[%d]", i);
            WebElement element = getWebEelement(By.xpath(xpath));
            System.out.println("nazwa zakładki : " + element.getText());
            element.click();
            clickFirstColumnLinks();
        }
    }

    public static void compareLinksFromFile() {
        SiteData.readData(FILE_PATH);
        for (int i = 0; i < SiteData.listOfLinks.size(); i++) {
            String string1 = String.valueOf(SiteData.listOfLinks.get(i));
            String string2 = String.valueOf(SiteData.lista.get(i));
            Assert.assertEquals(string1, string2);
        }
    }
}
