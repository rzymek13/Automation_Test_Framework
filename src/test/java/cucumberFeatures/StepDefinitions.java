package cucumberFeatures;

import Test.RanstadTest;
import Utils.WebDriverProvider;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

    @Given("open app")
    public void openApp() {
        WebDriverProvider.getDriver().get("https://www.randstad.pl/");
        RanstadTest.acceptCookies();
    }
    @When("i click on button")
    public void iClickOnButton() {
        RanstadTest.clickAllNavBarLinks();
    }
    @Then("lead me to correct site")
    public void leadMeToCorrectSite() {
        RanstadTest.compareLinksFromFile();
    }

}
