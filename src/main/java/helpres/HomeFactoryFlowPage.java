package helpres;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.LoginFactoryFlowPage;

public class HomeFactoryFlowPage {
    @FindBy(css = "#button secondary radius[href='/logout']")
    WebElement logOutButton;

    @FindBy(id = "flash")
    WebElement logoutMessage;

    public LoginFactoryFlowPage logout(WebDriver driver) {
        logOutButton.click();
        return PageFactory.initElements(driver, LoginFactoryFlowPage.class);

    }

}

