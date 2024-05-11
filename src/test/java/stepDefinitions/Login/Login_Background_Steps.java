package stepDefinitions.Login;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObject.Base_PO;
import static driver.DriverFactory.waitElement;

//USANDO O DRIVER DA BASE PAGE OBJECT

public class Login_Background_Steps extends Base_PO {

    private WebDriver driver = getDriver_PO();
    private WebDriverWait wait = waitElement();

    @Dado("a pagina de login - usando background")
    public void a_pagina_de_login_usando_background() {
        navigateTo_URL("https://www.webdriveruniversity.com/Login-Portal/index.html?");
    }
    @Quando("passo usuario {string} e senha {string}")
    public void passo_usuario_e_senha(String user, String pass) {

        sendKeys(By.id("text"), user);
//        driver.findElement(By.id("text")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(pass);
    }

    @Então("devo receber a seguinte mensagem sucesso {string}")
    public void devo_receber_a_seguinte_mensagem_sucesso(String msg) {
        driver.findElement(By.id("login-button")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), msg);
        alert.accept();
    }

    @Então("devo receber a seguinte mensagem sem sucesso {string}")
    public void devo_receber_a_seguinte_mensagem_sem_sucesso(String msg) {
        driver.findElement(By.id("login-button")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), msg);
        alert.accept();
    }
}
