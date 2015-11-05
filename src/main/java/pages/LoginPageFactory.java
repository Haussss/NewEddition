package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageFactory {

    @FindBy(id = "username")
    WebElement userName;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(css = "button[type='submit']")
    WebElement loginButton;

    public void loginFactory(String user, String pass) {
        userName.sendKeys(user);
        password.sendKeys(pass);
        loginButton.click();

    }

}
