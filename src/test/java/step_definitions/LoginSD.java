package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import pages.Login;
import pages.Page;

public class LoginSD {
    Login login;
    Page page;

    public LoginSD() {
        this.login = new Login(HooksSD.driver);
        this.page = new Page(HooksSD.driver);
    }

    @Given("Click on Login tab")
    public void clickLoginTab() {
        this.page.loginTab.click();
    }

    @When("^User enter \"(.*)\" and \"(.*)\"$")
    public void enterLoginCredentials(String email, String password) {
        this.login.enterLogin(email, password);
    }

    @And("Click on login button")
    public void clickLoginButton() {
        this.login.loginButton.click();
        HooksSD.rest();
    }

    @Then("User could login successfully")
    public void loginAssertion() {
        SoftAssert loginAssertion = new SoftAssert();
        loginAssertion.assertEquals(HooksSD.driver.getCurrentUrl(), "https://demo.nopcommerce.com/");
        loginAssertion.assertTrue(this.page.myAccountTab.isDisplayed());
        loginAssertion.assertAll();
    }
}
