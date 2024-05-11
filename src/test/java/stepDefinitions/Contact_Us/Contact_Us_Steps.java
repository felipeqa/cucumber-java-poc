package stepDefinitions.Contact_Us;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObject.Base_PO;

//USANDO O DRIVER VIA BASE PAGE OBJECT

public class Contact_Us_Steps extends Base_PO {

    private WebDriver driver = getDriver_PO();

    @Given("I access the web driver university contact us page")
    public void i_access_the_web_driver_university_contact_us_page() {
        navigateTo_URL("https://webdriveruniversity.com/Contact-Us/contactus.html");
    }

    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() throws InterruptedException {
        String firstName = "Luis Felipe " + generateRandomNumber(5);
        sendKeys(By.cssSelector("input[name=first_name]"), firstName);
//        driver.findElement(By.cssSelector("input[name=first_name]")).sendKeys(firstName);
    }

    @When("last name")
    public void last_name() {
        String lastName = "Oliveira " + System.currentTimeMillis();
        driver.findElement(By.cssSelector("input[name=last_name]")).sendKeys(lastName);
    }

    @When("email")
    public void email() {
        String email = "teste" + System.currentTimeMillis() + "@teste.com";
        driver.findElement(By.cssSelector("input[name=email]")).sendKeys(email);
    }

    @When("comment")
    public void comment() {
        driver.findElement(By.cssSelector("textarea[name=message]")).sendKeys("Estou comentando algo aqui, ok? Timestamp: " + System.currentTimeMillis());
    }

    @When("submit")
    public void submit() {
        driver.findElement(By.cssSelector("input[value=SUBMIT]")).click();
    }

    @Then("I should be present message")
    public void i_should_be_present_message() {
      String message =  driver.findElement(By.cssSelector("#contact_reply > h1")).getText();
      Assert.assertEquals(message, "Thank You for your Message!");
    }
}
