package step_defenetions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import pages.Page;

public class CurrencySwitchSD {
    Page page;
    Select selector;
    String Currency;

    public CurrencySwitchSD() {
        this.page = new Page(HooksSD.driver);
        this.selector = new Select(this.page.customerCurrency);
    }

    @Given("Look for products currency")
    public void lookProductsCurrency() {
        if (this.page.productCurrency.getText().contains("$")) {
            this.Currency = "US Dollar";
        } else {
            this.Currency = "Euro";
        }

    }

    @When("Change the currency")
    public void changeCurrency() {
        if (this.Currency == "US Dollar") {
            this.selector.selectByVisibleText("Euro");
            this.Currency = "Euro";
        } else {
            this.selector.selectByVisibleText("US Dollar");
            this.Currency = "US Dollar";
        }

        HooksSD.rest();
    }

    @Then("User could find the selected currency")
    public void currencyAssertion() {
        SoftAssert currencyAssertion = new SoftAssert();
        this.page.customerCurrency = this.selector.getFirstSelectedOption();
        currencyAssertion.assertTrue(this.page.customerCurrency.getText().contains(this.Currency));
        currencyAssertion.assertAll();
    }
}
