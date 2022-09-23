package StepDefinition;

import Pages.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

public class LoginSteps extends BaseClass {
    @Given("user is on login page")
    public void user_is_on_login_page() {
        setup();
    }

    @When("user enters username and password")
    public void user_enters_username_and_password() throws IOException {
        pageFactory.getLoginPage().enterLoginCredentials();
    }

    @And("clicks on login button")
    public void clicks_on_login_button() {
        pageFactory.getLoginPage().clickLoginButton();
    }

    @Then("user is navigated to home page")
    public void user_is_navigated_to_home_page() {
        pageFactory.getLoginPage().landingPageVerificationAfterLogin();
    }
}