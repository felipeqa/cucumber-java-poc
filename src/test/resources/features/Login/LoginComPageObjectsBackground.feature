# language: pt
@login_background @all @1 @e
Funcionalidade: Login da universidade webdriver - Usando Background Page Objects

  Contexto:
    Dado a pagina de login - usando background

  Cenario: Validar login - Sucesso - Page Object
    Quando passo usuario "webdriver" e senha "webdriver123" - Page Object
    Então devo receber a seguinte mensagem sucesso "validation succeeded" - Page Object

  Cenario: Validar login - Sem Sucesso- Page Object
    Quando passo usuario "testes" e senha "password" - Page Object
    Então devo receber a seguinte mensagem sem sucesso "validation failed" - Page Object

