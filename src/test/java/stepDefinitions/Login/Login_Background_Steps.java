package stepDefinitions.Login;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;


public class Login_Background_Steps {

    private WebDriver driver;

    @Before("@login_background")
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @After("@login_background")
    public void tearDown(){
        driver.quit();
    }

    @Dado("a pagina de login - usando background")
    public void a_pagina_de_login_usando_background() {
        driver.get("https://www.webdriveruniversity.com/Login-Portal/index.html?");
    }
    @Quando("passo usuario {string} e senha {string}")
    public void passo_usuario_e_senha(String user, String pass) {
        driver.findElement(By.id("text")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(pass);
    }

    @Então("devo receber a seguinte mensagem sucesso {string}")
    public void devo_receber_a_seguinte_mensagem_sucesso(String msg) {
        driver.findElement(By.id("login-button")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        Assert.assertEquals(alert.getText(), msg);
    }

    @Então("devo receber a seguinte mensagem sem sucesso {string}")
    public void devo_receber_a_seguinte_mensagem_sem_sucesso(String msg) {
        driver.findElement(By.id("login-button")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        Assert.assertEquals(alert.getText(), msg);

    }
}
