package stepDefinitions.POC_Dependencias;

import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.testng.Assert;

public class Teste2 {

    private double valor2Step2;
    private final Teste1 teste1;

    public Teste2(Teste1 teste1) {
        this.teste1 = teste1;
    }


    @Quando("quando valor teste2")
    public void quando_valor_teste2() {
        valor2Step2 = 22.5;
    }
    @Então("entao valor teste2")
    public void entao_valor_teste2() {
//        double total = valor2Step2 + valor1step1; //precisamos do valor1step1
        double total = valor2Step2 + teste1.getValor1Step1(); //precisamos do valor1step1
        Assert.assertEquals(total,32.5);
    }

    public double getValor2Step2() {
        return valor2Step2;
    }
}
