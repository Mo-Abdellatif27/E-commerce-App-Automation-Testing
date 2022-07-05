import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Register {
    public WebElement RegIconEl(WebDriver driver) {
        By regIcon = By.className("ico-register");
        WebElement IconEl = driver.findElement(regIcon);
        return IconEl;
    }
    public WebElement GenderEl(WebDriver driver) {
        By gender1 = By.id("gender-male");
        By gender2 = By.id("gender-female");
        WebElement GenderEl = driver.findElement(gender1);
        return GenderEl;
    }
    public WebElement FNEl(WebDriver driver) {
        By fname = By.id("FirstName");
        WebElement FNameEl = driver.findElement(fname);
        return FNameEl;
    }
    public WebElement LNEl(WebDriver driver) {
        By lname = By.id("LastName");
        WebElement LNameEl = driver.findElement(lname);
        return LNameEl;
    }
    public WebElement RegEmailEl(WebDriver driver) {
        By regEmail = By.id("Email");
        WebElement RegEmailEl = driver.findElement(regEmail);
        return RegEmailEl;
    }
    public WebElement RegPassEl(WebDriver driver) {
        By regPass = By.id("Password");
        WebElement RegPassEl = driver.findElement(regPass);
        return RegPassEl;
    }
    public WebElement RegConfEl(WebDriver driver) {
        By regConf = By.id("ConfirmPassword");
        WebElement RegConfEl = driver.findElement(regConf);
        return RegConfEl;
    }
}
