# language: pt

@api
Funcionalidade: Validar API Qualquer

  Cenario: API - Post

    Dado um json de uma api
    Quando enviou esse json
    Então entao devo validar sua resposta

  Cenario: API - Get
    Dado que eu faca um get na api
    Então devo validar o resultado