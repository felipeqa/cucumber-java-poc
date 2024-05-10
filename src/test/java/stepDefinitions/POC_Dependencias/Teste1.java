package stepDefinitions.POC_Dependencias;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.testng.Assert;

public class Teste1 {
    
    private int valor1Step1;
    private int valor1Step2;

    @Dado("dado valor teste1")
    public void dado_valor_teste1() {
        valor1Step1 = 10;
    }

    @Quando("quando valor teste1")
    public void quando_valor_teste1() {
        valor1Step2 = 20;
    }

    @Então("entao valor teste1")
    public void entao_valor_teste1() {

        int total = valor1Step1 + valor1Step2;
        Assert.assertEquals(total,30);
    }

    public int getValor1Step1() {
        return valor1Step1;
    }
}
