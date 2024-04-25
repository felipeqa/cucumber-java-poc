package stepDefinitions.Contato;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static driver.DriverFactory.getDriver;

public class Contato_Steps {
    private WebDriver driver = getDriver();

    @Dado("que eu acesse a pagina de contato")
    public void que_eu_acesse_a_pagina_de_contato() {
        driver.get("https://webdriveruniversity.com/Contact-Us/contactus.html");
    }
    @Quando("preencher meu nome")
    public void preencher_meu_nome() {
        String firstName = "Luis Felipe " + System.currentTimeMillis();
        driver.findElement(By.cssSelector("input[name=first_name]")).sendKeys(firstName);
    }
    @Quando("sobrenome")
    public void sobrenome() {
        String lastName = "Oliveira " + System.currentTimeMillis();
        driver.findElement(By.cssSelector("input[name=last_name]")).sendKeys(lastName);
    }
    @Quando("fazer um comentario")
    public void fazer_um_comentario() {
        driver.findElement(By.cssSelector("textarea[name=message]")).sendKeys("Estou comentando algo aqui, ok? Timestamp: " + System.currentTimeMillis());
    }
    @Quando("enviar")
    public void enviar() {
        driver.findElement(By.cssSelector("input[value=SUBMIT]")).click();
    }
    @Entao("eu recebo a seguinte mensagem {string}")
    public void eu_recebo_a_seguinte_mensagem(String msg) {
        String message =  driver.findElement(By.cssSelector("#contact_reply > h1")).getText();
        Assert.assertEquals(message, msg);
    }
}
