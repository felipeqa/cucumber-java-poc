package stepDefinitions.Contact_Us;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageObject.Contact_Us_PO;
import pageObject.Home_PO;

public class ContactUsPageObjectSteps {

    private Contact_Us_PO contactUsPo;
    private Home_PO homePo;

    public ContactUsPageObjectSteps(Contact_Us_PO contactUsPo, Home_PO homePo) {
        this.contactUsPo = contactUsPo;
        this.homePo = homePo;
    }

    @Given("I access the web driver university contact us page - With Page Objects")
    public void i_access_the_web_driver_university_contact_us_page_with_page_objects() {
        contactUsPo.visitContactUsPage();
    }

    @When("I enter a unique first name - With Page Objects")
    public void i_enter_a_unique_first_name_with_page_objects() {
        String firstName = "Luis Felipe " + contactUsPo.generateRandomNumber(5);
        contactUsPo.setFirstName(firstName);
    }

    @When("last name - With Page Objects")
    public void last_name_with_page_objects() {
        String lastName = "Oliveira " + System.currentTimeMillis();
        contactUsPo.setLastName(lastName);
    }
    @When("email - With Page Objects")
    public void email_with_page_objects() {
        String email = "teste" + System.currentTimeMillis() + "@teste.com";
        contactUsPo.setEmail(email);

    }
    @When("comment - With Page Objects")
    public void comment_with_page_objects() {
        String comment = "Estou comentando algo aqui, ok? Timestamp: " + System.currentTimeMillis();
        contactUsPo.setComments(comment);
    }
    @When("submit - With Page Objects")
    public void submit_with_page_objects() {
        contactUsPo.submitButton.click();
    }
    @Then("I should be present message - With Page Objects")
    public void i_should_be_present_message_with_page_objects() {
        homePo.waitFor(homePo.message);
        var message = homePo.message.getText();
        Assert.assertEquals(message, "Thank You for your Message!");
    }
}
