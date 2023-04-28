package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.LaunchEmulator;
import pages.purchaseProduct;

public class PurchaseStepDefinition extends LaunchEmulator {

    purchaseProduct PurchaseProduct = new purchaseProduct(driver);


    @Given("user Login with standard credentials and navigates to homepage")
    public void user_login_with_standard_credentials_and_navigates_to_homepage() {
        PurchaseProduct.loginUser();
    }

    @When("Select a product")
    public void select_a_product() {
        PurchaseProduct.selectProduct();
        PurchaseProduct.getProductDetails();
        PurchaseProduct.scrollDown();
    }

    @Then("click on add to cart button to add the product into cart")
    public void click_on_add_to_cart_button_to_add_the_product_into_cart() {
        PurchaseProduct.addToCart();
        PurchaseProduct.goToCart();
    }


    @Given("click on checkout button to continue the purchase process")
    public void click_on_checkout_button_to_continue_the_purchase_process() {
        PurchaseProduct.clickOnCheckout();
    }

    @When("add the customer detail")
    public void add_the_customer_detail() {
        PurchaseProduct.addCustomerDetails();
    }

    @Then("click on finish button and get the conformation message")
    public void click_on_finish_button_and_get_the_conformation_message() {
        PurchaseProduct.scrollDown();
        PurchaseProduct.getConformationMessage();
    }

}