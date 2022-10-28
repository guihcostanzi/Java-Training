# CONTRACT MANAGER SYS

## Como o preço de cada parcela é calculado :

1. Se insere o valor do contrato.
2. Se divide esse valor pelo número de parcelas optado pelo usuário.
3. Se adiciona uma taxa de juros simples de 1% a cada mês sobre as parcelas.
4. Se adiciona uma taxa de pagamento de 2% sobre a parcela, já acrescida dos juros.

**Exemplo :**

* Valor do Contrato ($) : 100.00
* Qtd. de Parcelas : 5
* Valor Base p/ Parcela ($) : 20.00

*Cálculo para a primeira (#1) parcela :*

* Valor Acrescido de Juros : 20 + 1% * 1 = 20.2  *Obs : Vezes 1 porque é o primeiro mês, o segundo mês seria x2.*
* Valor Acrescido de Juros e Taxa de Pagamento : 20.2 + 2% = 20.604.
* Valor Final da #1 Parcela : $ 20.60

## Interface

A interface OnlinePaymentSys possibilita estabelecer um contrato com a classe que irá atuar como Sistema de Pagamento,
garantindo que irá implementar os métodos de interesse e deixando o código mais flexível a mudanças.

Se algum dia o PaypalPaymentService precisar ser substituido, basta troca na instanciação do objeto ContractService. Não 
será necessário ter mais pontos de contato em outras classes.
