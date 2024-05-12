package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home_PO  extends Base_PO{

    public Home_PO() {
        super();
    }

    @FindBy(css = "#contact_reply > h1")
    public WebElement message;
}
