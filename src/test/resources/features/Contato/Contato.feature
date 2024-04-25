 # language: pt

 @contato @1
 Funcionalidade: Contato com a universidade

  Cenario: Validar o envio de contato

    Dado que eu acesse a pagina de contato
    Quando preencher meu nome
    E sobrenome
    E email
    E fazer um comentario
    E enviar
    E eu recebo a seguinte mensagem "Thank You for your Message!"