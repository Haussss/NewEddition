package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StaticLoginPage {
    public static final By USER_NAME_FIELD = By.id("username");
    public static final By PASS_FIELD = By.id("password");
    public static final By LOGIN_BUTTON = By.id("button[type='submit']");
    public static final By FLASH = By.cssSelector("");

    public static void login(WebDriver driver, String user, String pass) {
        driver.findElement(USER_NAME_FIELD).sendKeys(user);
        driver.findElement(PASS_FIELD).sendKeys(pass);
        driver.findElement(LOGIN_BUTTON).click();
    }
}
