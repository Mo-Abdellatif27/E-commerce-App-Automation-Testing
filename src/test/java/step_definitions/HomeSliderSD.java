package step_definitions;

import pages.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

public class HomeSliderSD {
    Page page;

    public HomeSliderSD() {
        this.page = new Page(HooksSD.driver);
    }

    @Given("Click on Nokia banner controller")
    public void clickNokiaController() {
        this.page.controllerNokia.click();
    }

    @When("Click on Nokia banner")
    public void clickNokiaBanner() {
        this.page.bannerNokia.click();
        HooksSD.rest();
    }

    @Then("User could click on the banner and redirect to the Nokia link")
    public void slidersAssertionNokia() {
        SoftAssert slidersAssertion = new SoftAssert();
        slidersAssertion.assertEquals(this.page.bannerNokia.getAttribute("href"), "http://demo.nopcommerce.com/");
        slidersAssertion.assertAll();
    }

    @Given("Click on IPhone banner controller")
    public void clickIPhoneController() {
        this.page.controllerIPhone.click();
    }

    @When("Click on IPhone banner")
    public void clickIPhoneBanner() {
        this.page.bannerIPhone.click();
    }

    @Then("User could click on the banner and redirect to the IPhone link")
    public void slidersAssertionIPhone() {
        SoftAssert slidersAssertion = new SoftAssert();
        slidersAssertion.assertEquals(this.page.bannerIPhone.getAttribute("href"), "http://demo.nopcommerce.com/");
        slidersAssertion.assertAll();
    }
}
