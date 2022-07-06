package step_defenetions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.Page;

public class HooksSD {
    public static WebDriver driver = null;

    public static void rest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
    }

    @Before
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        rest();
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Given("Scroll down and choose a random product and click on it")
    public void chooseProduct() throws InterruptedException {
        Actions action = new Actions(driver);
        action.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{Keys.PAGE_DOWN, Keys.PAGE_DOWN})});
        Thread.sleep(1000L);
        Page page = new Page(driver);
        page.macbookPicture.click();
        rest();
    }
}
