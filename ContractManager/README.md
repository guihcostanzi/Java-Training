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

### Herança ( extends ) vs Interface ( implements )

**Ao mesmo tempo que os dois conceitos tem pontos semelhantes, como:**

1. Relação "É um" das classes que herdam ou implementam, ou seja : Uma classe BrazilTaxService que herda/implementa a classe TaxService irá gerar objetos 
que também são TaxService.
2. Polimorfismo, possibilitado pela interação acima.
3. Generalização e Especialização, ou seja, há uma classe genérica que poderá gerar classes mais específicas.

**Note que os dois conceitos são diferentes.**

#### * Herança :

* Há a incorporação dos métodos e atributos da classe pai na classe filha, um reuso.

#### * Interface :

* Não possui atributos, mas atua como um contrato que dita o que a classe que irá implementar a interface deve fazer, seus métodos.
* Com os *Default Methods* é possível fazer o reuso dos métodos da Interface nas classes que a implementam, como em : 
```
 public interface TreatmentService {
 
   Double getTreatmentTax ();

   Default Double treatmentFinalPrice (Double price, Double hospitalFee) {
      return price + hospitalFee + (price + hospitalFee)*geTreatmentTax;  
   }
   
 }
 
```
*Nesse caso, o método treatmentFinalPrice () será reutilizado nas classes que implementarem a interface TreatmentService.*

Obs : O método getTreatmentTax () não pode ser default nesse caso pois dependeria de um atributo para ser implementado, e interfaces não têm
atributos. Pelo mesmo motivo interfaces não têm construtores.
