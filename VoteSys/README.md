## MAP

O map é uma coleção que trabalha com <CHAVE, VALOR>. Os elementos são acessados através de sua chave.

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

