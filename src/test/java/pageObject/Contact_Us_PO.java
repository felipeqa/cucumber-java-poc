package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Contact_Us_PO  extends Base_PO{

    public Contact_Us_PO() {
        super();
    }

    @FindBy(how = How.CSS, using = "input[name=first_name]")
    private WebElement firstName;

    @FindBy(css = "input[name=last_name]")
    private WebElement lastName;

    @FindBy(css = "input[name=email]")
    private WebElement email;

    @FindBy(css = "textarea[name=message]")
    private WebElement comments;

    @FindBy(css = "input[value=SUBMIT]")
    public WebElement submitButton;


    public void visitContactUsPage(){
        navigateTo_URL("https://webdriveruniversity.com/Contact-Us/contactus.html");
    }

    public void setFirstName(String nome) {
        sendKeys(firstName, nome);
    }

    public void setLastName(String sobrenome) {
        sendKeys(lastName, sobrenome);
    }

    public void setEmail(String email){
        sendKeys(this.email, email);
    }

    public void setComments(String comments) {
        sendKeys(this.comments, comments);
    }
}
