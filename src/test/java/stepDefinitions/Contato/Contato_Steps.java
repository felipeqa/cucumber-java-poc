package stepDefinitions.Contato;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class Contato_Steps {
    @Dado("que eu acesse a pagina de contato")
    public void que_eu_acesse_a_pagina_de_contato() {
        System.out.println("1");
    }
    @Quando("preencher meu nome")
    public void preencher_meu_nome() {
        System.out.println("2");
    }
    @Quando("sobrenome")
    public void sobrenome() {
        System.out.println("3");
    }
    @Quando("fazer um comentario")
    public void fazer_um_comentario() {
        System.out.println("4");
    }
    @Quando("enviar")
    public void enviar() {
        System.out.println("5");
    }
    @Entao("eu recebo a seguinte mensagem {string}")
    public void eu_recebo_a_seguinte_mensagem(String string) {
        System.out.println(string);
    }
}
