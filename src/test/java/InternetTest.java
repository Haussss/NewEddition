import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import java.util.concurrent.TimeUnit;

public class InternetTest {
    private WebDriver driver;
    private ByPage loginPage;
    private LoginPageFactory loginFactory;
    private LoginFactoryFlowPage flowPage;
    private HomePage homePage;
    private final static String BASE_URL = "http://the-internet.herokuapp.com/";
    private final String USER_NAME ="tomsmith";
    private final String PASSWORD ="SuperSecretPassword!";
    private UIMapLoginPage loginPagee;

    @BeforeMethod
    public void setup() {
        //  driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        driver.get(BASE_URL);
        loginPage = new ByPage(driver);
        loginFactory = PageFactory.initElements(driver, LoginPageFactory.class);
        homePage = PageFactory.initElements(driver, HomePage.class);
        flowPage = PageFactory.initElements(driver, LoginFactoryFlowPage.class);
        loginPagee = new UIMapLoginPage(driver);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void loginTest(){
        driver.findElement(By.linkText("Form Authentication")).click();
        loginPage.login(USER_NAME,PASSWORD);
        Assert.assertTrue(driver.findElement(By.cssSelector("#flash.success")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("a[href='/logout']")).isDisplayed());
    }
    @Test

    public void LoginFactoryTest(){
        loginFactory.loginFactory(USER_NAME, PASSWORD);
        Assert.assertTrue(driver.findElement(By.cssSelector("#flash.success")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("a[href='logout']")).isDisplayed());
    }
    @Test

    public void LogoutFactoryTest(){
        driver.findElement(By.linkText("Form Authentication")).click();
        loginFactory.loginFactory(USER_NAME, PASSWORD);
        homePage.logout();
        Assert.assertTrue(driver.findElement(By.cssSelector("#flash.success")).isDisplayed());
    }
    @Test

    public void LogoutFactoryFlowTest() {
        driver.findElement(By.linkText("Form Authentication")).click();
        flowPage
                .login(driver,USER_NAME, PASSWORD)
                .logout(driver)
                .verifyOnLoginPage(driver);
    }
    @Test
    public void UIMapLoginTest (){
        driver.findElement(By.linkText("Form Authentication")).click();
        loginPagee.login("tomsmith", "SuperSecretPassword!");
        Assert.assertTrue(driver.findElement(By.cssSelector("#flash.success")).isDisplayed());

    }
    @Test
    public void staticLoginTest(){
        driver.findElement(By.linkText("Form Authentication")).click();
        StaticLoginPage.login(driver, "tomsmith", "SuperSecretPassword!");
        Assert.assertTrue(driver.findElement(StaticLoginPage.FLASH).isDisplayed());
    }
}
