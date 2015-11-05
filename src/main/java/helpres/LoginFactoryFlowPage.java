package helpres;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginFactoryFlowPage {

        @FindBy(id = "username")
        WebElement userName;

        @FindBy(id = "password")
        WebElement password;

        @FindBy(css = "button[type='submit']")
        WebElement loginButton;

        public HomeFactoryFlowPage login(WebDriver driver,String user, String pass){
            userName.sendKeys(user);
            password.sendKeys(pass);
            loginButton.click();
            return PageFactory.initElements(driver, HomeFactoryFlowPage.class);

        }
public LoginFactoryFlowPage verifyOnLoginPage(WebDriver driver){
    Assert.assertTrue(loginButton.isDisplayed());
    return PageFactory.initElements(driver, LoginFactoryFlowPage.class);
}
    }


