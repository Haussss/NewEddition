package helpres;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementPage {
    private final WebDriver driver;

    By userName = By.id("username");
    By pswdFied = By.id("password");
    By Button = By.cssSelector("button[type='submit']");
    private WebElement userNameField;
    private WebElement pswdField;
    private WebElement loginButton;
    public WebElementPage(WebDriver driver){

        this.driver = driver;
        userNameField=driver.findElement(userName);
        pswdField=driver.findElement(pswdFied);
        loginButton=driver.findElement(Button);
    }
    public void login (String user,String pswd){
        userNameField.sendKeys(user);
        pswdField.sendKeys(pswd);
        loginButton.click();
    }
}

