//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import pages.Register;
import pages.Page;

public class RegisterSD {
    Register register;

    public RegisterSD() {
        this.register = new Register(HooksSD.driver);
    }

    @Given("Click on Register tab")
    public void clickRegisterTab() {
        Page p = new Page(HooksSD.driver);
        p.registerTab.click();
    }

    @When("Click on any radio button to chose gender")
    public void choseGender() {
        this.register.gender.click();
    }

    @And("User enter First name and Last name")
    public void fillName() {
        this.register.firstName.sendKeys(new CharSequence[]{"Gherkin"});
        this.register.lastName.sendKeys(new CharSequence[]{"Cucumber"});
    }

    @And("User Select Date of Birth: Select [Day, Month, Year]")
    public void pickDate() {
        this.register.dobDay.click();
        this.register.dobMonth.click();
        this.register.dobYear.click();
    }

    @And("^User enter email: \"(.*)\"$")
    public void fillEmail(String email) {
        this.register.email.sendKeys(new CharSequence[]{email});
    }

    @And("Fill Company name")
    public void fillCompanyName() {
        this.register.company.sendKeys(new CharSequence[]{"Selenium"});
    }

    @And("^User enter Password and Confirm it: \"(.*)\"$")
    public void fillPassword(String password) {
        this.register.password.sendKeys(new CharSequence[]{password});
        this.register.confirmPassword.sendKeys(new CharSequence[]{password});
    }

    @And("Click on REGISTER button")
    public void clickRegisterButton() {
        this.register.registerButton.click();
        HooksSD.rest();
    }

    @Then("User could register successfully")
    public void RegistrationAssertion() {
        SoftAssert registrationAssertion = new SoftAssert();
        registrationAssertion.assertTrue(this.register.registrationComplete.getText().contains("Your registration completed"));
        registrationAssertion.assertEquals(this.register.registrationComplete.getCssValue("color"), "rgba(76, 177, 124, 1)");
        registrationAssertion.assertAll();
    }

    @And("Click on CONTINUE button")
    public void clickContinue() {
        this.register.continueButton.click();
        HooksSD.rest();
    }
}
