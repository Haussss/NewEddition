package helpres;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WebDriverUtils {
    public static boolean isElementExist(WebDriver driver, By by) {
        List<WebElement> elementList = driver.findElements(by);
        return !elementList.isEmpty();
    }

    public static void check(WebElement checkbox) {
        setCheckBoxTo(checkbox, true);

    }

    public static void uncheck(WebElement checkbox) {
        setCheckBoxTo(checkbox, false);
    }

    private static void setCheckBoxTo(WebElement checkbox, boolean value) {
        if (checkbox.isSelected() != value) {
        }
        checkbox.click();

    }

    public static boolean isAlertPresent(WebDriver driver) {

        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException ex) {
            return false;
        }


    }

    public void WaitForElement(WebDriver driver, int timeout, final By locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });


    }

    public void waitForJquerry(final WebDriver driver, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver input) {
                JavascriptExecutor ex = (JavascriptExecutor) driver;
                return (Boolean) ex.executeScript("return JQuery.active == 0");
            }
        });
    }

    public void waitForPageToLoad(final WebDriver driver, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver input) {
                JavascriptExecutor ex = (JavascriptExecutor) driver;
                return ((String) ex.executeScript("return document.readyState")).equals("complete");
            }
        });
    }
}
