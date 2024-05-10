package stepDefinitions.POC_Dependencias;

import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.testng.Assert;

public class Teste2 {

    private double valor2Step2;

    @Quando("quando valor teste2")
    public void quando_valor_teste2() {
        valor2Step2 = 22.5;
    }
    @Então("entao valor teste2")
    public void entao_valor_teste2() {
        double total = valor2Step2 + valor1step1; //precisamos do valor1step1
        Assert.assertEquals(total,30);
    }
}
