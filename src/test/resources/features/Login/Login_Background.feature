# language: pt
@login_background @all
Funcionalidade: Login da universidade webdriver - Usando Background

  Contexto:
    Dado a pagina de login - usando background

  Cenario: Validar login - Sucesso
    Quando passo usuario "webdriver" e senha "webdriver123"
    Então devo receber a seguinte mensagem sucesso "validation succeeded"

  Cenario: Validar login - Sem Sucesso
    Quando passo usuario "testes" e senha "password"
    Então devo receber a seguinte mensagem sem sucesso "validation failed"

