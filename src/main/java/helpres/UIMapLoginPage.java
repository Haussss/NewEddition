package helpres;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UIMapLoginPage {
private final WebDriver driver;
    public static final By USER_NAME_FIELD= Locators.get("login.userNameField");
    public static final By PSWD_FIELD=Locators.get("login.pswdField");
    public static final By LOGIN_BUTTON=Locators.get("login.loginButton");

    public UIMapLoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void login(String user,String pswd){
        driver.findElement(USER_NAME_FIELD).sendKeys(user);
        driver.findElement(PSWD_FIELD).sendKeys(pswd);
        driver.findElement(LOGIN_BUTTON).click();
    }
}
