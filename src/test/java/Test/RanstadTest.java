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

    @Test
    public void randstadFirstTest() {
        WebDriverProvider.getDriver().get("https://www.randstad.pl/");
        WebElement cookieAcceptButton = getWebEelement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        cookieAcceptButton.click();
        navBar();
//        System.out.println(SiteData.lista);
        SiteData.readData(FILE_PATH);
        for (int i = 0; i < SiteData.listOfLinks.size(); i++) {
            String string1 = String.valueOf(SiteData.listOfLinks.get(i));
            System.out.println(string1);
            String string2 = String.valueOf(SiteData.lista.get(i));
            System.out.println(string2);
            Assert.assertEquals(string1,string2);
        }
    }

    public void firstColumnCheck() {
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
    public void navBar() {
        List<WebElement> navBarList = getWebEelements(By.xpath("//ul[@class='navigation__menu navigation__menu--main hidden--until-l']/li"));
        for (int i = 1; i <= navBarList.size() ; i++) {
            String xpat = String.format("(//ul[@class='navigation__menu navigation__menu--main hidden--until-l']/li/a)[%d]",i);
            WebElement element = getWebEelement(By.xpath(xpat));
            System.out.println("nazwa zakładki : " + element.getText());
            element.click();
            firstColumnCheck();
        }
    }
}
