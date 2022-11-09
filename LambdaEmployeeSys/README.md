## PROGRAMAÇÃO FUNCIONAL & LAMBDA

Funções anônimas que define uma interface funcional, que o compilador identifica pela estrutura da arrow function ( apelido da função lambda).

Exemplo :

````
List<String> nameList = Arrays.asList("Maria", "Ana", "Bruna", "Fábio");

nameList.sort((x,y) -> x.compareTo(y));

nameList.forEach(System.out::println);
````

Observe que a estrutura de uma arrow function é : " <parâmetros> -> <implementação da função> ";

No caso da função anônima poder ser escrita em apenas uma linha, o uso de chaves e do return é dispensado, pois já fica subententido.
Quando se tem mais de uma linha, se deve usar chaves :

````
(x,y) -> {
  return x+y;
}
````

Ou seja : 
* Do lado esquerdo, os parâmetros;
* Do lado direito, a implementação, podendo ser de : Predicate, Consumer, Function, Comparator, etc...

### PREDICATE

Uma função que retorna um booleano, ou seja, True or False.

````
List<String> nameList = new ArrayList<>();
		
nameList.add("Carlos");
nameList.add("Chris");
nameList.add("Marta");
nameList.add("Logan");
nameList.add("Amanda");

nameList.removeIf(p -> p.toUpperCase().charAt(0) == 'C');

nameList.forEach(System.out::println);
````

Note que nesse caso, o método removeIf() pede um Predicate, que retornará True or False.
* Caso retorne True, o elemento irá ser removido.
* Caso retorne False, nada acontece ao elemento.

*Esse mesmo comportamento pode ser observado no método filter(), durante um pipeline, por exemplo.*

### CONSUMER

Usado para executar uma ação, alteração. Não retorna nada.

````
List<Product> products = new ArrayList<>();

products.add(new Product("Televisão", 200.00));
products.add(new Product("Computador", 1000.00));

prices.forEach(p -> p.setPrice(p.getPrice() * 1,1));

prices.forEach(System.out::println);
````
*Obs : Considere uma classe Product com atributos nome e preço, com getters e settes implementados.*

Observe que nesse caso foi feita uma alteração, mas não houve retorno algum.

### FUNCTION 

Recebe um parâmetro do tipo T, e retorna um objeto do tipo R.

````
List<Product> products = new ArrayList<>();

products.add(new Product("Televisão", 200.00));
products.add(new Product("Computador", 1000.00));

List<String> names = products.stream()
		       .map(p -> p.getName().toUpperCase())
		       .collect(Collectors.toList());
		         
names.forEach(System.out::println);
````
*Obs : Considere uma classe Product com atributos nome e preço, com getters e settes implementados.*

Nesse caso, recebeu um parâmetro do tipo Product, e retornou um do tipo String. Poderia ser String,String , Product,Double , Double,Double etc...

## STREAMS

Stream é uma solução para manipular sequências de dados.
* Acesso sequencial (Sem posições).
* Sem efeitos colaterais.
* Sob demanda ( lazy evaluation ).
* Uso único.

Uma vez que operações em streams retornam novas streams, é possível criar uma espécie de linha de montagem, uma cadeia de operações, chamada pipeline.

### PIPELINE

É composto por nenhuma ou várias operações intermediárias e apenas uma operação terminal.

* Operação Intermediária : Produz novas streams. É executada apenas quando uma operação final é chamada (lazy evaluation).
  Exemplo :
  1. filter();
  2. map();
  3. sorted();
  4. limit(); * operação short-circuit : limita o processamento da stream.
  
* Operação Terminal : Produz um objeto que não seja uma Stream, uma coleção (lista) por exemplo. Demarca o fim do processamento da Stream, da pipeline.
  Exemplo :
  1. forEach();
  2. reduce();
  3. collect();
  4. anyMatch() * ;
  5. findFirst() * ;

Exemplo de Pipeline :

*Soma dos produtos abaixo de $ 300.00*
````
List<Product> products = new ArrayList<>();

products.add(new Product("Televisão", 200.00));
products.add(new Product("Computador", 1000.00));
products.add(new Product("Rádio", 150.00));
products.add(new Product("Celular", 290.00));

double sum = products.stream()
    .filter(p -> p.getPrice() < 300)
    .map(p -> p.getPrice())
    .reduce(0.0, (x,y) -> x+y);


System.out.println(sum);
````
*Obs : Considere uma classe Product com atributos nome e preço, com getters e settes implementados.*

Observe que foram utilizados duas operações intermediárias e apenas uma operação terminal para finalizar.
