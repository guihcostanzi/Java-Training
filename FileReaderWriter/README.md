# -- PROJETO TESTE COM FILE, FILEREADER E FILEWRITER --

Para funcionar corretamente, é necessário que se passe um path ( caminho do arquivo ). 

## Ex. de Path do arquivo :

C:\FileGenSys\SoldItens.txt

O arquivo deve ter seu conteúdo seguindo esse modelo :

## Ex. Conteúdo :

* *Televisão,2000.90,1*
* *Rádio,300.90,2*
* *Pneu,100.90,4*
* *Celular,1200.90,2*

É necessário colocar um tipo de produto em cada linha, com suas informações 
separadas por ' , ' (vírgula) conforme no exemplo acima, de preferência sem 
espaços, uma vez que será utiliza a função split do Java para retornar um 
array, em que : **[0] nome**, **[1] preço**, **[2] qtd. vendida**.

A função split recebe como separador a vírgula ( , ), portanto, se deve
utilizar ponto ( . ) para separar números com ponto flutuante (decimais).

## Se utilizado o arquivo apontado por "C:\FileGenSys\SoldItens.txt", 
## o resultado será esse :

 1. --------------dd/MM/yyyy HH:mm--------------
 2. Product : Televisão, Total Sales : $ 2000,90
 3. Product : Rádio, Total Sales : $ 601,80
 4. Product : Pneu, Total Sales : $ 403,60
 5. Product : Celular, Total Sales : $ 2401,80
 6. ---------------------- *END* -----------------------

*Obs : Essa informação é gravada em "C:\FileGenSys\Summary",*
*dentro de um arquivo "SalesSummary-yyyy-MM-dd.txt.*

## Índice :
* dd : Dia 
* MM : Mês
* yyyy : Ano
* HH : Hora
* mm : Minuto

*Exemplo : dd/MM/yyyy HH:mm --> 27/08/2003 18:30.*
*Exemplo 2 : SalesSummary-yyyy-MM-dd.txt --> SalesSummary-2003-08-27.txt.*

**Esses atributos de tempo acompanham o fuso horário local do sistema em que se está gerando os relatórios.**

## Criação da pasta Summary :

**A pasta Summary e os relatórios gerados dentro dela se comportam dessa forma :**

* A pasta Summary é gerada dentro da pasta em que o arquivo lido inicialmente se encontra,
uma vez que se utiliza o getParent() no arquivo passado no começo do programa para determinar o local de criação da pasta.

* Caso a pasta já tenha sido gerada anteriormente, ela será reutilizada. Isso é, caso o arquivo passado esteja 
na mesma pasta em que a pasta Summary foi gerada anteriormente.

* Em um arquivo SalesSummary-2022-10-22.txt, ficarão armazenados todos os relatórios gerados no dia 22/10/2022, dito isso,
um novo arquivo será gerado apenas se ocorrer mudança de data.



