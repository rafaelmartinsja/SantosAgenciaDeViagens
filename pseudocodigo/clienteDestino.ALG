Algoritmo "clientesDestino"
// Disciplina   : [Linguagem e Lógica de Programação] 
// Professor   : Flávio Mota da Cruz & Gustavo Guanabara 
Var

cliente:vetor[1..5] de caracter
destino:vetor[1..5] de caracter
i:inteiro

Inicio
// entrada de dados

para i de 1 ate 5 faca
     escreva("Digite o nome do cliente: ")
     leia(cliente[i])
     escreva("Digite o destino: ")
     leia(destino[i])
fimpara

// saida de dados - valores dos vetores

escrevaL(" ")

para i de 1 ate 5 faca

escreval("CLIENTE: ", cliente[i], " DESTINO: ", destino[i])

fimpara

Fimalgoritmo