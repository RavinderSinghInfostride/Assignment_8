package StepDefinition;

import Pages.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

public class AddProductToCartAndCheckout extends BaseClass {
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        setup();
    }

    @When("user enters the username and the password")
    public void user_enters_the_username_and_the_password() throws IOException {
        pageFactory.getLoginPage().enterLoginCredentials();
    }

    @And("clicks on the login button")
    public void clicks_on_the_login_button() {
        pageFactory.getLoginPage().clickLoginButton();
    }

    @Then("user is navigated to the home page")
    public void user_is_navigated_to_the_home_page() {
        pageFactory.getLoginPage().landingPageVerificationAfterLogin();
    }

    @And("user clicks add to cart button of a product and checkout")
    public void user_clicks_add_to_cart_button_of_a_product_checkout() throws IOException {
        pageFactory.getAddProductToCart().addProductToCartAndCheckout();
    }

    @Then("browser closes")
    public void browser_closes() {
        close();
    }
}