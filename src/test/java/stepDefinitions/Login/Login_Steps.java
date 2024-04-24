package stepDefinitions.Login;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import stepDefinitions.base.Hooks;

public class Login_Steps extends Hooks {

    @Dado("a pagina de login")
    public void a_pagina_de_login() {
        driver.get("https://www.webdriveruniversity.com/Login-Portal/index.html?");
    }

    @Quando("passo {string} e {string}")
    public void passo_e(String user, String pass) {
        driver.findElement(By.id("text")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(pass);

    }

    @Então("devo receber a seguinte mensagem {string}")
    public void devo_receber_a_seguinte_mensagem(String mensagem) {
        driver.findElement(By.id("login-button")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        Assert.assertEquals(alert.getText(), mensagem);
    }
}
