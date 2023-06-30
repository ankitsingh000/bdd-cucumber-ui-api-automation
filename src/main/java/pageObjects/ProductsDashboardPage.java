package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.DriverFactory;
import utils.SeleniumUtil;


public class ProductsDashboardPage extends DriverFactory {
    By productHeader = By.xpath("//span[@id='productTitle']");

    By addToCart = By.xpath("//input[@id='add-to-cart-button']");

    By closeSideMenu = By.xpath("//a[@id='attach-close_sideSheet-link']");

    By proceedToCheckOut = By.xpath("//div[@id='attach-desktop-sideSheet']//input[@aria-labelledby='attach-sidesheet-checkout-button-announce']");
    public WebElement productName() {
        return SeleniumUtil.waitForElementToBeVisible(driver,productHeader);
    }

    public WebElement addToCart() {
        return SeleniumUtil.waitForElementToBeVisible(driver,addToCart);
    }
    public WebElement proceedToCheckout(){
        return SeleniumUtil.waitForElementToBeVisible(driver,proceedToCheckOut);
    }

    public WebElement closeSideMenu() {
        return SeleniumUtil.waitForElementToBeVisible(driver,closeSideMenu);
    }
}
