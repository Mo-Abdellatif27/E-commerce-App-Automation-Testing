package step_definitions;

import pages.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

public class CategoryHoverSD {
    Page page;
    Actions hover;

    public CategoryHoverSD() {
        this.page = new Page(HooksSD.driver);
        this.hover = new Actions(HooksSD.driver);
    }

    @Given("Hover the header menu and select random category then hover it")
    public void hoverHeader() {
        this.hover.moveToElement(this.page.headerMenu).perform();
        HooksSD.rest();
        this.hover.moveToElement(this.page.menuComputers).perform();
        HooksSD.rest();
    }

    @When("Click on random sub-category if found")
    public void clickSubCategory() {
        this.hover.moveToElement(this.page.submenuSoftware);
        HooksSD.rest();
        this.hover.click().build().perform();
        HooksSD.rest();
    }

    @Then("User could open sub-category page")
    public void hoverAssertion() {
        SoftAssert registrationAssertion = new SoftAssert();
        registrationAssertion.assertEquals(HooksSD.driver.getCurrentUrl(), "https://demo.nopcommerce.com/software");
        registrationAssertion.assertAll();
    }
}
