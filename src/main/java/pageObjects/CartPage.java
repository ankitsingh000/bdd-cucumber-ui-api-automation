package pageObjects;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.DriverFactory;
import utils.SeleniumUtil;



public class CartPage extends DriverFactory {

	By productName = By.xpath("//span[@class='a-truncate-cut']");
	By firstProduct = By.xpath("(//span[@class='a-truncate-cut'])[1]");

	By proceedToBuy = By.xpath("//input[@name='proceedToRetailCheckout']");

	By checkoutHeader = By.xpath("//h1");
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	
	public int itemCount() {

		final List<WebElement> cartItems =driver.findElements(By.cssSelector("#cart_contents_container > div > div.cart_list > div.cart_item"));
		return cartItems.size();
	}




	public void checkNumberOfItems(int actual, int expected) {
		try{
			Assert.assertEquals(actual,expected);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void clickCheckout() {
		WebElement checkoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("CHECKOUT")));
		checkoutButton.click();
	}

	public List<WebElement> getProductName() {
		SeleniumUtil.waitForElementToBeVisible(driver,firstProduct);
		return driver.findElements(productName);
	}

	public WebElement proceedToCheckOut() {
		return SeleniumUtil.waitForElementToBeClickable(driver,proceedToBuy);
	}

	public WebElement checkoutHeader() {
		return SeleniumUtil.waitForElementToBeVisible(driver,checkoutHeader);
	}
}
