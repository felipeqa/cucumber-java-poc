# language: pt

@poc
Funcionalidade: Compartilhar dados entre os steps Teste 3

  Cenario: Terceiro teste Base - Valor 1 + valor do 2

    Dado dado valor teste1
    Quando quando valor teste2
    Então entao valor teste3

  Cenario: Terceiro teste Base - Valor 1 + valor 3

    Dado dado valor teste1
    Quando quando valor teste3
    Então entao a soma do teste3 e teste1