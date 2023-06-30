package stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import pageObjects.CartPage;
import utils.AssertionsUtility;
import java.util.List;

public class Cart {

    CartPage cartPage = new CartPage();
    @Then("User should be able to see selected {string} in cart")
    public void user_should_be_able_to_see_selected_item_in_cart(String product){
        String actualProduct = cartPage.getProductName().get(0).getText();
        AssertionsUtility.getSoftAssert().assertEquals(actualProduct.trim(),product.trim(),"Same Product Not added to cart");
    };

    @When("User Click on the {string} button")
    public void user_click_on_the_button(String string){
        cartPage.proceedToCheckOut().click();
    };

    @Then("Ensure that the checkout page is loaded successfully")
    public void ensure_that_the_checkout_page_is_loaded_successfully() {
        String actualHeader = cartPage.checkoutHeader().getText();
        AssertionsUtility.getSoftAssert().assertEquals(actualHeader,"Checkout","Unable to load Checkout page");
    };
}