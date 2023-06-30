package stepDefs;

import io.cucumber.java.en.*;
import pageObjects.AmazonDashboardPage;
import pageObjects.LoginPage;
import pageObjects.ProductsDashboardPage;
import utils.SeleniumUtil;

public class AmazonDashboard {


    public AmazonDashboardPage amazonDashboardPage = new AmazonDashboardPage();
    public ProductsDashboardPage productsDashboardPage = new ProductsDashboardPage();

    @When("User search for an {string} to add in Cart")
    public void user_search_for_an_item_to_add_in_cart(String product){
        amazonDashboardPage.searchForProduct().sendKeys(product);
        amazonDashboardPage.searchButton().click();
    };

    @When("User Add a {string} to the cart")
    public void user_add_product_to_the_cart(String product){
        amazonDashboardPage.product(product).click();
        amazonDashboardPage.switchTabsToProductPage();
        String actualProductName=productsDashboardPage.productName().getText();
        productsDashboardPage.addToCart().click();
        productsDashboardPage.closeSideMenu().click();

    };

    @When("User Click on the cart icon to view the cart page")
    public void user_click_on_the_cart_icon_to_view_the_cart_page(){
        amazonDashboardPage.javaScriptExecutor(amazonDashboardPage.cartIcon());
    };






}
