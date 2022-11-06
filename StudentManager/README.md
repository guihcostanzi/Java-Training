## SET

Set é uma coleção de valores em que cada elemento só aparece uma vez. Os elementos não têm posições, existindo algumas variações de Set's para que se
possa trabalhar com a ordem dos elementos no Set.

#### HASHSET

Mais performático. A ordem dos elementos não importa, não existe.

#### LINKEDHASHSET

Performance mediana. A ordem dos elementos segue a ordem da inserção.

#### TREESET

Baixa performance. A ordem dos elementos é decidida com base no compareTo() dos elementos.

**Exemplo :**

```
public class Product implements Comparable<Product> {

	private String name;
	private Double price;

	public Product(String name, Double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int compareTo(Product other) {
		return price.compareTo(other.getPrice());
	}

}
```
**Neste caso, o set será ordenado por ordem de preço, já que o compareTo() de Product prioriza esse atributo.**

### Operações com Sets

*size();
*contains();
*add();
*remove();

##### União 

* addAll(); 

Obs : Adiciona ao Set todos os elementos de um outro Set. Devido às propriedades do Set, um elemento não pode se repetir, originando, com esse método, a união
entre os dois Sets que interagem com o método.

##### Interseção

* retainAll();

Obs : Retém no Set todos os elementos que também aparecem no outro Set, passado como argumento. Deleta os elementos que não têm correspondência no outro Set.

Exemplo : 

Set A : (1, 2, 3, 4);
Set B : (1, 2, 7, 9);

```
A.retainAll(B);
```
Set A : (1,2);

##### Diferença

* removeAll();

Obs : Remove do Set todos os elementos contidos no outro Set, passado como argumento.

Exemplo : 

Set A : (1, 2, 3, 4);
Set B : (1, 2, 7, 9);

```
A.removeAll(B);
```
Set A : (3, 4);
