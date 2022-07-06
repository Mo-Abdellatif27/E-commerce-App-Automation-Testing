package step_definitions;

import pages.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

public class SearchSD {
    Page page;
    String SearchProduct;

    public SearchSD() {
        this.page = new Page(HooksSD.driver);
    }

    @Given("^Type \"(.*)\" on search text box$")
    public void searchProduct(String product) {
        this.page.search.sendKeys(new CharSequence[]{product});
        this.SearchProduct = product;
    }

    @When("Click on SEARCH button or hit enter key")
    public void clickSearch() {
        this.page.searchButton.click();
        HooksSD.rest();
    }

    @Then("User could find Apple products")
    public void searchAssertion() {
        SoftAssert searchAssertion = new SoftAssert();
        searchAssertion.assertEquals(this.page.searchKeyword.getAttribute("value"), this.SearchProduct);
        searchAssertion.assertAll();
    }

    @Then("User could find Apple product")
    public void skuSearchAssertion() {
        SoftAssert searchAssertion = new SoftAssert();
        searchAssertion.assertEquals(this.page.searchKeyword.getAttribute("value"), this.SearchProduct);
        searchAssertion.assertAll();
    }
}
