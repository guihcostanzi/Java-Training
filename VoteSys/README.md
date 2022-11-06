## MAP

O map é uma coleção que trabalha com <CHAVE, VALOR>. Os elementos são acessados através de sua chave. Não se pode repetir chaves.

````
Map<Integer, String> people = new HashMap<>();

people.put(23, "Alex");
````

Nesse caso, foi adicionado no map um elemento em que :

1. A chave é o ID 23.
2. O valor é a pessoa Alex.

Para acessar a pessoa Alex, se utilizará a chave 23.

#### HASHMAP

Mais performático. Sem ordenação.

#### LINKED HASHMAP

Performance média. Ordenação por ordem de inserção.

#### TREEMAP

Baixa performance. Ordenação utilizando o compareTo() do elemento.

### MÉTODOS 

* put(); // Adiciona elementos ao Map. 
* remove(); // Remove elementos do Map.
* constainsKey(); // Verifica se o Map possui a chave passada como argumento.
* get(); // Retorna o valor associada a chave passada como argumento.
* clear();
* size();
* keySet();
* values();

### EXPERIMENTO

Por que o método containsKey retorna true, se não foi adicionado nenhuma key pX como elemento do Map ?

Obs : Considere uma classe Product, com os atributos nome e preço. Esta classe possui HashCode e Equals implementados, considerando o nome e o preço.

Obs : Esse Map irá armazenar um objeto produto como chave e sua quantidade no estoque.

````
Map<Product, Integer> stock = new HashMap<>();
		
		Product p1 = new Product ("TV", 900.0);
		Product p2 = new Product ("CELULAR", 1000.0);
		Product p3 = new Product ("TABLET", 800.0);
		
		stock.put(p1, 1000);
		stock.put(p2, 300);
		stock.put(p3, 800);
		
		Product pX = new Product ("TV", 900.0);
		
		System.out.println(stock.containsKey(pX)); //true
````
RES : O método retorna true porque o Map utiliza HashCode e Equals para verificar se uma chave se associa a um valor. Nesse caso, p1 e pX são a mesma chave para o método, uma vez que ambos são objetos produto, com o mesmo nome e preço.

Se o HashCode e Equals não estivesse implementado na Classe Product, então o método retornaria false, uma vez que a comparação por referências constataria diferença.

### Outro caso :

````
Map<Integer, String> people = new HashMap<>();
		
		people.put(1, Paola);
		people.put(2, Carla);
		people.put(3, Alex);
   		people.put(1, Olaf);
    
   		System.out.println(people.get(5)); \\null
		
````

Nesse caso, a chave 01 teria seu valor atualizado para Olaf, uma vez que não se pode ter reincidência de chaves.

O método get() retorna null, já que essa chave não existe, e não há valor associado a ela.
