package pageObjects;


import static org.junit.Assert.assertTrue;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import utils.DriverFactory;
import utils.SeleniumUtil;

public class AmazonDashboardPage extends DriverFactory {


	By inputSearchBox = By.xpath("//input[@id='twotabsearchtextbox']");
	By searchButton = By.xpath("//input[@id='nav-search-submit-button']");

	By cartIconButton = By.xpath("//a[@id='nav-cart']/div[@id='nav-cart-count-container']");

	String mainDashboardHandle;


	public WebElement searchForProduct() {
		return SeleniumUtil.waitForElementToBeVisible(driver,inputSearchBox);
	}

	public WebElement searchButton() {
		return SeleniumUtil.waitForElementToBeClickable(driver,searchButton);
	}

	public WebElement product(String product) {
		String paramXpath = "//span[text()='"+product+"' and @class='a-size-medium a-color-base a-text-normal']";
		By xpath = By.xpath(paramXpath);
		return SeleniumUtil.waitForElementToBeClickable(driver,xpath);
	}

	public void switchTabsToProductPage() {
		String mainDashBoardTab=SeleniumUtil.switchTabs(driver);
		setTabDashBoard(mainDashBoardTab);


	}

	private void setTabDashBoard(String mainDashBoardTab) {
		this.mainDashboardHandle=mainDashBoardTab;
	}
	public String getMainDashboardHandle(){
		return mainDashboardHandle;
	}

	public WebElement cartIcon() {
		return SeleniumUtil.waitForElementToBeClickable(driver,cartIconButton);
	}

	public void javaScriptExecutor(WebElement cartIcon) {
		SeleniumUtil.javaScriptExecutor(driver,cartIcon);
	}
}

