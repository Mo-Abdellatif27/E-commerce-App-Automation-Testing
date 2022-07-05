import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
    public WebElement LogEmailEl(WebDriver driver) {
        By logEmail = By.id("Email");
        WebElement LogEmailEl = driver.findElement(logEmail);
        return LogEmailEl;
    }
    public WebElement LogPassEl(WebDriver driver) {
        By logPass = By.id("Password");
        WebElement LogPassEl = driver.findElement(logPass);
        return LogPassEl;
    }
    public WebElement LogIconEl(WebDriver driver) {
        By logIcon = By.className("ico-login");
        WebElement LogIconEl = driver.findElement(logIcon);
        return LogIconEl;
    }
}
