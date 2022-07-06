package step_defenetions;

import pages.Page;
import pages.Product;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

public class ShoppingCartSD {
    public ShoppingCartSD() {
    }

    @When("Click on ADD TO CART button")
    public void addCart() throws InterruptedException {
        Product product = new Product(HooksSD.driver);
        product.addCart.click();
        HooksSD.rest();
        Thread.sleep(1000L);
    }

    @Then("the product is added to the user's shopping cart and message appears says The product has been added to your shopping cart")
    public void cartAssertion() {
        Page page = new Page(HooksSD.driver);
        SoftAssert wishlistAssertion = new SoftAssert();
        wishlistAssertion.assertEquals(page.successNotificationContent.getText(), "The product has been added to your shopping cart");
        wishlistAssertion.assertEquals(page.successNotification.getCssValue("background-color"), "rgba(75, 176, 122, 1)");
        wishlistAssertion.assertAll();
    }
}
