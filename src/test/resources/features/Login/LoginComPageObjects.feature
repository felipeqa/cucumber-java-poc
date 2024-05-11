# language: pt
@loginPO
Funcionalidade: Login da universidade webdriver com Page Object

  Esquema do Cenario: : Validar login com Page Object

    Dado a pagina de login - Page Object
    Quando passo <user> e <senha> - Page Object
    Então devo receber a seguinte mensagem <mensagem> - Page Object

    Exemplos:
      | user       | senha         | mensagem |
      | "webdriver"| "webdriver123"| "validation succeeded"|
      | "teste"    | "teste"       | "validation failed"    |
