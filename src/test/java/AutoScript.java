import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AutoScript {
    WebDriver driver;
    SoftAssert soft;
    Register register;
    Login login;

    //Constructor
    public AutoScript() {
        String Path = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",Path);
        driver = new ChromeDriver();
        soft = new SoftAssert();
        register = new Register();
        login = new Login();
    }

    @BeforeTest
    public void OpenBrowser() {
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
 }

    //SC1 Valid Registration
    @Test
    public void Register() throws InterruptedException {
        register.RegIconEl(driver).click();
        register.GenderEl(driver).click();
        register.FNEl(driver).sendKeys("Tester");
        register.LNEl(driver).sendKeys("S");
        register.RegEmailEl(driver).sendKeys("test@gmail.com");
        register.RegPassEl(driver).sendKeys("1234567m");
        register.RegConfEl(driver).sendKeys("1234567m");
        Thread.sleep(2000);
        driver.findElement(By.id("register-button")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        String Expected = "Your registration completed";
        String Actual = driver.findElement(By.className("result")).getText();
        soft.assertEquals(Actual,Expected);
        Thread.sleep(3000);
        soft.assertAll();
    }

    //SC2 Valid Login
    @Test
    public void Login() throws InterruptedException{
        login.LogIconEl(driver).click();
        login.LogEmailEl(driver).sendKeys("test@gmail.com");
        login.LogPassEl(driver).sendKeys("1234567m");
        Thread.sleep(2000);
        login.LogPassEl(driver).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        String Expected = "Welcome to our";
        String Actual = driver.findElement(By.className("topic-block-title")).getText();
        soft.assertTrue(Actual.contains(Expected),"You are not registered");
        soft.assertTrue(driver.findElement(By.cssSelector("a[href=\"/logout\"]")).isDisplayed());
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("a[href=\"/logout\"]")).click();
        Thread.sleep(2000);
        soft.assertAll();
    }

    //SC3 Reset Password
    @Test
    public void ResPassword() throws InterruptedException {
        login.LogIconEl(driver).click();
        Thread.sleep(1000);
        driver.findElement(By.className("forgot-password")).click();
        driver.findElement(By.id("Email")).sendKeys("test@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.id("Email")).sendKeys(Keys.ENTER);
        String Expected = "Email with instructions has been sent to you.";
        String Actual = driver.findElement(By.className("content")).getText();
        soft.assertEquals(Actual,Expected);
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("span[class=\"close\"]")).click();
    }

    //SC4 Search Items
    @Test
    public void Search() throws InterruptedException {
        login.LogIconEl(driver).click();
        driver.findElement(By.id("Email")).sendKeys("test@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("1234567m");
        driver.findElement(By.id("Password")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.id("small-searchterms")).sendKeys("HTC One M8");
        driver.findElement(By.id("small-searchterms")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        String Expected = "HTC";
        String Actual = driver.findElement(By.className("product-title")).getText();
        Assert.assertTrue(Actual.contains(Expected),"Item is not found");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("a[href=\"/logout\"]")).click();
        Thread.sleep(2000);
    }

    //SC5 Currency Switch
    @Test
    public void CurrSwitch() throws InterruptedException {
        login.LogIconEl(driver).click();
        driver.findElement(By.id("Email")).sendKeys("test@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("1234567m");
        driver.findElement(By.id("Password")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.id("customerCurrency")).click();
        driver.findElement(By.cssSelector("option[value=\"https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("a[href=\"/logout\"]")).click();
        Thread.sleep(3000);
    }

    //SC6 Choose Category
    @Test
    public void SelCat() throws InterruptedException {
        login.LogIconEl(driver).click();
        driver.findElement(By.id("Email")).sendKeys("test@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("1234567m");
        driver.findElement(By.id("Password")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.cssSelector("a[href=\"/apparel\"]"));
        action.moveToElement(we).build().perform();
        Thread.sleep(3000);

        //SC6 Choose Sub-category
        driver.findElement(By.cssSelector("a[href=\"/shoes\"]")).click();
        Thread.sleep(3000);

        //SC7 Choose Color
        driver.findElement(By.id("attribute-option-15")).click();
        Thread.sleep(5000);

        //SC8 Choose Tag
        driver.findElement(By.cssSelector("a[href=\"/book\"]")).click();
        Thread.sleep(3000);

        //SC10 Add to Wishlist
        driver.findElement(By.cssSelector("button[title=\"Add to wishlist\"]")).click();
        String Expected = "The product has been added";
        String Actual = driver.findElement(By.id("bar-notification")).getText();
        soft.assertTrue(Actual.contains(Expected),"Error! Not Added");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("span[class=\"close\"]")).click();
        Thread.sleep(3000);

        //SC11 Add to Comparelist
        driver.findElement(By.cssSelector("button[class=\"button-2 add-to-compare-list-button\"]")).click();
        String Expected1 = "The product has been added";
        String Actual1 = driver.findElement(By.id("bar-notification")).getText();
        soft.assertTrue(Actual1.contains(Expected1),"Error! Not Added");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("span[class=\"close\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("a[href=\"/logout\"]")).click();
        Thread.sleep(2000);
    }

    //SC9 & SC12
    @Test
    public void Order() throws InterruptedException {
        //SC9 Add to Card
        login.LogIconEl(driver).click();
        driver.findElement(By.id("Email")).sendKeys("test@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("1234567m");
        driver.findElement(By.id("Password")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.cssSelector("a[href=\"/electronics\"]"));
        action.moveToElement(we).build().perform();
        driver.findElement(By.cssSelector("a[href=\"/camera-photo\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[class=\"button-2 product-box-add-to-cart-button\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[id=\"add-to-cart-button-14\"]")).click();
        String Expected = "The product has been added";
        String Actual = driver.findElement(By.id("bar-notification")).getText();
        soft.assertTrue(Actual.contains(Expected),"Error! Not Added");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("span[class=\"close\"]")).click();
        Thread.sleep(3000);
        //SC12 CheckOut
        driver.findElement(By.cssSelector("a[href=\"/cart\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[id=\"termsofservice\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button[class=\"button-1 checkout-button\"]")).click();
        Thread.sleep(1000);
        Thread.sleep(1000);
        driver.findElement(By.id("BillingNewAddress_CountryId")).sendKeys("egypt");
        driver.findElement(By.id("BillingNewAddress_CountryId")).sendKeys(Keys.ENTER);
        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Cairo");
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("Al-Haram St");
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("71865");
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("01021569600");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button[class=\"button-1 new-address-next-step-button\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button[class=\"button-1 shipping-method-next-step-button\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button[class=\"button-1 payment-method-next-step-button\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button[class=\"button-1 payment-info-next-step-button\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button[class=\"button-1 confirm-order-next-step-button\"]")).click();
        Thread.sleep(1000);
        String Expected2 = "Your order has been successfully processed!";
        String Actual2 = driver.findElement(By.cssSelector("div[class=\"title\"]")).getText();
        soft.assertEquals(Actual2,Expected2);
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[class=\"button-1 order-completed-continue-button\"]")).click();
        Thread.sleep(3000);
    }

    @AfterTest
    public void QuitTest() {
        driver.quit();
    }
}
