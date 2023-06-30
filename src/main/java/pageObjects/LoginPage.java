package pageObjects;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import utils.DriverFactory;
import utils.SeleniumUtil;

import javax.swing.*;


public class LoginPage extends DriverFactory {
	By accountSignIn = By.xpath("//header[@id='navbar-main']//following::a[@data-nav-role='signin' and @id='nav-link-accountList']");
	By usernameInputField = By.xpath("//label[@for='ap_email']//following-sibling::input[@type='email']");

	By enteredPhoneNumber = By.xpath("//h1//parent::div/div//span");
	By password = By.xpath("//input[@id='ap_password']");
	By continueButton = By.xpath("//input[@id='continue']");

	By userDetails = By.xpath("//header[@id='navbar-main']//following::a[@data-nav-role='signin' and @id='nav-link-accountList']//div/span");

	By submitButton = By.xpath("//input[@id='signInSubmit']");


	public WebElement accountSignInButton(){
		return SeleniumUtil.waitForElementToBeClickable(driver,accountSignIn);
	}

	public WebElement userNameInput(){
		return SeleniumUtil.waitForElementToBeClickable(driver,usernameInputField);
	}



	public WebElement continueButton() {
		return SeleniumUtil.waitForElementToBeClickable(driver,continueButton);
	}

	public WebElement userName() {
		return SeleniumUtil.waitForElementToBeVisible(driver,enteredPhoneNumber);
	}

	public WebElement password() {
		return SeleniumUtil.waitForElementToBeClickable(driver,password);
	}


	public WebElement submit() {
		return SeleniumUtil.waitForElementToBeClickable(driver,submitButton);
	}

	public WebElement userDetails() {
		return SeleniumUtil.waitForElementToBeVisible(driver,userDetails);
	}
}
