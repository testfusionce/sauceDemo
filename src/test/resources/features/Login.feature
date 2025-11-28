# language: en

@login
Feature: Realizar acesso ao site e funcionalidades

  @sucessoLogin
  Scenario: Login com credenciais validas
    Given acesso o site saucedemo
    When preencho o campo Login valido
    And preencho o campo senha correta
    And clico no botao de login
    Then realizo o login no site saucedemo

  @erroLogin
  Scenario: Login com credenciais invalidas
    Given acesso o site saucedemo
    When preencho o campo Login valido
    And preencho o campo senha incorreta correta
    And clico no botao de login
    Then valido a mensagem de erro

  @realizaCompraSucesso
  Scenario: Realizar compra de produto na loja
    Given acesso o site saucedemo
    When preencho o campo Login valido
    And preencho o campo senha correta
    And clico no botao de login
    And realizo o login no site saucedemo
    And seleciono o produto para compra
    And clico no carrinho de compras
    And verifico a lista de produtos desejados
    And clico no botao finalizar compras
    And preenhco as informações do cliente
    And confiro o resumo da compra
    Then finalizo a compra do produto
