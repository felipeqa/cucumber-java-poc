package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_PO extends Base_PO {

    public Login_PO() {
        super();
    }

    @FindBy(id = "text")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public void visit(String url){
        navigateTo_URL(url);
    }

    public void login (String user, String pass) {
//        sendKeys(username, user);

        //quando tenho um webElement posso chamar sendkeys, click direto, a partir dele
        username.sendKeys(user);

        sendKeys(password, pass);
        waitForWebElementAndClick(loginButton);
    }
}
