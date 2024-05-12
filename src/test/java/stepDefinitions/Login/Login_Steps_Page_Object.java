package stepDefinitions.Login;

import driver.DriverFactory;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pageObject.Login_PO;

public class Login_Steps_Page_Object {

    private Login_PO loginPo;

    public Login_Steps_Page_Object(Login_PO loginPo) {
        this.loginPo = loginPo;
    }

    @Dado("a pagina de login - Page Object")
    public void a_pagina_de_login_page_object() {
        loginPo.visit("https://www.webdriveruniversity.com/Login-Portal/index.html?");
    }

    @Quando("passo {string} e {string} - Page Object")
    public void passo_e_page_object(String user, String pass) {
        //validando o funcionamento do método
        loginPo.waitFor(By.id("text"));

        loginPo.login(user, pass);
    }

    @Então("devo receber a seguinte mensagem {string} - Page Object")
    public void devo_receber_a_seguinte_mensagem_page_object(String msg) {

        //usei meu método do driver factory waitElement (metodo foi apenas um exemplo estatico e acessivel)
        DriverFactory.waitElement().until(ExpectedConditions.alertIsPresent());
        Alert alert = loginPo.getDriver_PO().switchTo().alert();
        System.out.println(alert.getText());
        Assert.assertEquals(alert.getText(), msg);
        alert.accept();
    }

}
