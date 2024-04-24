package stepDefinitions.Contact_Us;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Contact_Us_Steps {

    private WebDriver driver;

   @Before("@contact_us")
   public void setup(){
       System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
       ChromeOptions chromeOptions = new ChromeOptions();
       chromeOptions.addArguments("--remote-allow-origins=*");
       chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
       driver = new ChromeDriver(chromeOptions);
       driver.manage().window().maximize();
   }

   @After("@contact_us")
   public void tearDown(){
       driver.quit();
   }

    @Given("I access the web driver university contact us page")
    public void i_access_the_web_driver_university_contact_us_page() {
        driver.get("https://webdriveruniversity.com/Contact-Us/contactus.html");
    }

    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() throws InterruptedException {
        String firstName = "Luis Felipe " + System.currentTimeMillis();
        driver.findElement(By.cssSelector("input[name=first_name]")).sendKeys(firstName);
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
