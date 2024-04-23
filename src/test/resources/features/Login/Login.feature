# language: pt
@login @all
Funcionalidade: Login da universidade webdriver

  Esquema do Cenario: : Validar login

    Dado a pagina de login
    Quando passo <user> e <senha>
    Então devo receber a seguinte mensagem <mensagem>

  Exemplos:
  | user       | senha         | mensagem |
  | "webdriver"| "webdriver123"| "validation succeeded"|
  | "teste"    | "teste"       | "validation failed"    |

