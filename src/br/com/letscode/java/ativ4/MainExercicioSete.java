//Reescreva a questão 7 da Lista 3 usando POO "Escreva um programa que
// lê nome e idade de 5 pessoas e ao final informa quem é o mais novo, o mais velho e qual a média de idade.

package br.com.letscode.java.ativ4;

public class MainExercicioSete {
    public static void main(String[] args) {
        Pessoa[] pessoas = new Pessoa[5];

        pessoas[0] = new Pessoa("Almir", 30);
        pessoas[1] = new Pessoa("Meire", 32);
        pessoas[2] = new Pessoa("Carol", 25);
        pessoas[3] = new Pessoa("Rodrigo", 28);
        pessoas[4] = new Pessoa("Fran", 21);

        int maisVelho = 0;
        int maisNovo = 0;
        int somatorio = 0;

        for(int i=0; i<pessoas.length; i++){
            if(pessoas[i].getIdade() > pessoas[maisVelho].getIdade()){
                maisVelho = i;
            }
            if(pessoas[i].getIdade() < pessoas[maisNovo].getIdade()){
                maisNovo = i;
            }
            somatorio += pessoas[i].getIdade();
        }

        System.out.println("A pessoa mais nova é: "+ pessoas[maisNovo].getNome());
        System.out.println("A pessoa mais velha é: "+ pessoas[maisVelho].getNome());
        System.out.printf("A média de idade são: %d", somatorio/pessoas.length);
    }
}
