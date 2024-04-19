package stepDefinitions.Contact_Us;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Contact_Us_Steps {
    @Given("I access the web driver university contact us page")
    public void i_access_the_web_driver_university_contact_us_page() {
        System.out.println("Teste 1");
    }

    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        System.out.println("Teste2");
    }

    @When("last name")
    public void last_name() {
        System.out.println("Teste3");
    }

    @When("email")
    public void email() {
        System.out.println("Teste4");
    }

    @When("comment")
    public void comment() {
        System.out.println("Teste5");
    }

    @When("submit")
    public void submit() {
        System.out.println("Teste6");
    }

    @Then("I should be present message")
    public void i_should_be_present_message() {
        System.out.println("Teste7");
    }
}
