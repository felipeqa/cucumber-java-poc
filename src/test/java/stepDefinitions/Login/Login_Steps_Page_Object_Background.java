package stepDefinitions.Login;

import driver.DriverFactory;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pageObject.Login_PO;

public class Login_Steps_Page_Object_Background {

    private Login_PO login_po;

    public Login_Steps_Page_Object_Background(Login_PO login_po) {
        this.login_po = login_po;
    }

    @Quando("passo usuario {string} e senha {string} - Page Object")
    public void passo_usuario_e_senha_page_object(String user, String pass) {
        login_po.login(user, pass);
    }

    @Então("devo receber a seguinte mensagem sucesso {string} - Page Object")
    public void devo_receber_a_seguinte_mensagem_sucesso_page_object(String msg) {

        DriverFactory.waitElement().until(ExpectedConditions.alertIsPresent());
        Alert alert = login_po.getDriver_PO().switchTo().alert();
        Assert.assertEquals(alert.getText(), msg);
        alert.accept();
    }

    @Então("devo receber a seguinte mensagem sem sucesso {string} - Page Object")
    public void devo_receber_a_seguinte_mensagem_sem_sucesso_page_object(String msg) {

        DriverFactory.waitElement().until(ExpectedConditions.alertIsPresent());
        Alert alert = login_po.getDriver_PO().switchTo().alert();
        Assert.assertEquals(alert.getText(), msg);
        alert.accept();

    }
}
