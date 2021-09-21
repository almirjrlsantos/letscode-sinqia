//Reescreva a questão 7 da Lista 3 usando POO "Escreva um programa que
// lê nome e idade de 5 pessoas e ao final informa quem é o mais novo, o mais velho e qual a média de idade.
package br.com.letscode.java.ativ4;

import java.util.ArrayList;

public class MainExercicioSete {
    public static void main(String[] args) {
        ArrayList<Pessoa> pessoas = new ArrayList();

        Pessoa pessoa = new Pessoa("Almir",30);
        pessoas.add(pessoa);
        pessoa = new Pessoa("Meire",32);
        pessoas.add(pessoa);
        pessoa = new Pessoa("Carol",20);
        pessoas.add(pessoa);
        pessoa = new Pessoa("Rodrigo",25);
        pessoas.add(pessoa);
        pessoa = new Pessoa("Fran",21);
        pessoas.add(pessoa);

        int maisVelho = 0;
        int maisNovo = 0;
        int somatorio = 0;

        for(int i=0; i<pessoas.size(); i++){
            if(pessoas.get(i).getIdade() > pessoas.get(maisVelho).getIdade()){
                maisVelho = i;
            }
            if(pessoas.get(i).getIdade() < pessoas.get(maisNovo).getIdade()){
                maisNovo = i;
            }
            somatorio += pessoas.get(i).getIdade();
        }

        System.out.println("A pessoa mais nova é: "+ pessoas.get(maisNovo).getNome());
        System.out.println("A pessoa mais velha é: "+ pessoas.get(maisVelho).getNome());
        System.out.printf("A média de idade são: %d", somatorio/pessoas.size());

    }
}
