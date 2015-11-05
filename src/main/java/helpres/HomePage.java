package helpres;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

   // public class LogOutPageFactorty {
//        @CacheLookup
//        @FindBy(id = "username")
//        WebElement userName;
//
//        @FindBy(id = "passworrd")
//        WebElement password;
//
//        @FindBy(css = "button[type='submit']")
//        WebElement loginButton;

        @FindBy(css = "#button[href='/logout']")
        WebElement logOutButton;

        @FindBy(id = "flash" )
        WebElement logoutMessage;

        public void logout(){
            logOutButton.click();

        }

    }

