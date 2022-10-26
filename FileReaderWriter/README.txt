** PROJETO TESTE COM FILE, FILEREADER E FILEWRITER **

PARA FUNCIONAR CORRETAMENTE, É NECESSÁRIO QUE SE PASSE O CAMINHO DE UM
ARQUIVO NO MODELO:

**Ex. para Path do arquivo :**

C:\FileGenSys\SoldItens.txt

**Ex. Conteúdo :**

Televisão,2000.90,1
Rádio,300.90,2
Pneu,100.90,4
Celular,1200.90,2

É necessário colocar um tipo de produto em cada linha, com suas informações 
separadas por ' , ' (vírgula) conforme no exemplo acima, de preferência sem 
espaços, uma vez que será utiliza a função split do Java para retornar um 
array, em que : [0] nome, [1] preço, [2] qtd. vendida.

A função split recebe como separador a vírgula ( , ), portanto, se deve
utilizar ponto ( . ) para separar números com ponto flutuante (decimais).
