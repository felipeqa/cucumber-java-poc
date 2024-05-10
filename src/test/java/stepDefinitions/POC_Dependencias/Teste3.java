package stepDefinitions.POC_Dependencias;

import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class Teste3 {

    private final Teste1 teste1;
    private final Teste2 teste2;

    public Teste3(Teste1 teste1, Teste2 teste2) {
        this.teste1 = teste1;
        this.teste2 = teste2;
    }

    @Então("entao valor teste3")
    public void entao_valor_teste3() {

    }

    @Quando("quando valor teste3")
    public void quando_valor_teste3() {

    }
}
