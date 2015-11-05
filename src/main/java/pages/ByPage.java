package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ByPage {
    private final WebDriver driver;

    public final By userName = By.id("username");
    public final By pswdFied = By.id("password");
    public final By button = By.cssSelector("button[type='submit']");

    public ByPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String user, String pass) {
        driver.findElement(userName).sendKeys(user);
        driver.findElement(pswdFied).sendKeys(pass);
        driver.findElement(button).click();

    }
}
