package step_defenetions;

import pages.Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

public class FollowSD {
    Page page;
    Actions keys;
    SoftAssert urlAssertion;

    public FollowSD() {
        this.page = new Page(HooksSD.driver);
        this.keys = new Actions(HooksSD.driver);
        this.urlAssertion = new SoftAssert();
    }

    @Given("Scroll down to the bottom")
    public void scrollDown() {
        JavascriptExecutor executor = (JavascriptExecutor)HooksSD.driver;
        executor.executeScript("window.scrollBy(0,document.body.scrollHeight)", new Object[0]);
        HooksSD.rest();
    }

    @When("Click on facebook icon")
    public void clickFacebook() throws InterruptedException {
        this.page.facebook.click();
        Thread.sleep(3000L);
        this.keys.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{Keys.LEFT_CONTROL, Keys.TAB})});
    }

    @And("Click on twitter icon")
    public void clickTwitter() throws InterruptedException {
        this.page.twitter.click();
        Thread.sleep(3000L);
        this.keys.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{Keys.LEFT_CONTROL, Keys.TAB})});
    }

    @And("Click on rss icon")
    public void clickRSS() throws InterruptedException {
        this.keys.keyDown(Keys.LEFT_CONTROL).click(this.page.rss).keyUp(Keys.LEFT_CONTROL).build().perform();
        Thread.sleep(3000L);
        this.keys.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{Keys.LEFT_CONTROL, Keys.TAB})});
    }

    @And("Click on youtube icon")
    public void clickYoutube() throws InterruptedException {
        this.page.youtube.click();
        Thread.sleep(3000L);
        this.keys.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{Keys.LEFT_CONTROL, Keys.TAB})});
    }

    @Then("User could open facebook page")
    public void facebookAssertion() {
        this.urlAssertion.assertEquals(this.page.facebook.getAttribute("href"), "http://www.facebook.com/nopCommerce");
        this.urlAssertion.assertAll();
    }

    @And("User could open twitter page")
    public void twitterAssertion() {
        this.urlAssertion.assertEquals(this.page.twitter.getAttribute("href"), "https://twitter.com/nopCommerce");
        this.urlAssertion.assertAll();
    }

    @And("User could open rss page")
    public void rssAssertion() {
        this.urlAssertion.assertEquals(this.page.rss.getAttribute("href"), "https://demo.nopcommerce.com/news/rss/1");
        this.urlAssertion.assertAll();
    }

    @And("User could open youtube page")
    public void youtubeAssertion() {
        this.urlAssertion.assertEquals(this.page.youtube.getAttribute("href"), "http://www.youtube.com/user/nopCommerce");
        this.urlAssertion.assertAll();
    }
}
