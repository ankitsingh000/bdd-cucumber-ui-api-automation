package stepDefs;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pageObjects.LoginPage;
import java.util.logging.Logger;

public class LoginStep {

	public LoginPage loginPage = new LoginPage();

	@Given("User Navigate to the Amazon website and clicks on Sign in button")
	public void user_navigate_to_the_amazon_website() {
		loginPage.accountSignInButton().click();
	};

	@When("User enter valid login credentials {string} and {string}")
	public void user_enter_valid_login_credentials(String username, String password) {
		loginPage.userNameInput().sendKeys(username);
		loginPage.continueButton().click();
		String actualUserName=loginPage.userName().getText();
		loginPage.password().sendKeys(password);
		loginPage.submit().click();
	};

	@Then("Verify that the {string} is successfully logged in")
	public void verify_that_the_user_is_successfully_logged_in(String user) {
		try{
			String actualUserDetails=loginPage.userDetails().getText();
			Assert.assertEquals(actualUserDetails,user,"User Unable to login");
		}catch (Exception e){
			e.printStackTrace();
		}
	};
}