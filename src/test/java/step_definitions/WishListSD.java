package step_definitions;

import pages.Page;
import pages.Product;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

public class WishListSD {
        public WishListSD() {
        }

        @When("Click on add to wishlist icon")
        public void addProduct() throws InterruptedException {
            Product product = new Product(HooksSD.driver);
            product.wishListIcon.click();
            HooksSD.rest();
            Thread.sleep(1000L);
        }

        @Then("the product is added to the user's wishlist and message appears says The product has been added to your wishlist")
        public void wishlistAssertion() {
            Page page = new Page(HooksSD.driver);
            SoftAssert wishlistAssertion = new SoftAssert();
            wishlistAssertion.assertEquals(page.successNotificationContent.getText(), "The product has been added to your wishlist");
            wishlistAssertion.assertEquals(page.successNotification.getCssValue("background-color"), "rgba(75, 176, 122, 1)");
            wishlistAssertion.assertAll();
        }
}
