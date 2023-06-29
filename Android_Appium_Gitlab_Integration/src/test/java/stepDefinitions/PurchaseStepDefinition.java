package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.LaunchEmulator;
import pages.purchaseProduct;

import java.util.logging.Logger;

public class PurchaseStepDefinition extends LaunchEmulator {
    protected static Logger logger = Logger.getLogger(PurchaseStepDefinition.class.getName());

    purchaseProduct purchaseProduct = new purchaseProduct(driver);


    @Given("I am on Login page")
    public void i_am_on_login_page() {
        purchaseProduct.isLoginButtonDisplay();
        logger.info("signIn page is available");
    }

    @When("I click on username and password field it takes input")
    public void i_click_on_username_and_password_field_it_takes_input() {
        purchaseProduct.loginUser("standard_user", "secret_sauce");
    }

    @Then("click on singIn button")
    public void click_on_sing_in_button() {
        purchaseProduct.clickOnLoginButton();
        logger.info("signIn successfully");
    }
}