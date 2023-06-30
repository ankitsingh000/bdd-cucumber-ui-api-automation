package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class SeleniumUtil {

    public static WebElement waitForElementToBeClickable(WebDriver driver, By xpath){
        WebDriverWait wait = new WebDriverWait(driver,60);
        return wait.until(ExpectedConditions.elementToBeClickable(xpath));
    }

    public static WebElement waitForElementToBeVisible(WebDriver driver,By xpath){
        WebDriverWait wait = new WebDriverWait(driver,60);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));


    }

    public static String switchTabs(WebDriver driver) {
        String getCurrentHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String window: windowHandles) {
            if(!window.equals(getCurrentHandle)){
                driver.switchTo().window(window);
            }
        }
        return getCurrentHandle;

    }

    public static void javaScriptExecutor(WebDriver driver, WebElement target) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", target);
    }
}
