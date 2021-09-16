//Escreva um programa que lê nome e idade de 5 pessoas e ao final informa quem é o mais novo,
// o mais velho e qual a média de idade.
package br.com.letscode.java.ativ3;

public class Exerc7 {
    public static void main(String[] args) {
        String[][] matriz = {{"Almir","30"},{"Meire","32"},{"Carol","20"},{"Rodrigo","25"},{"Fran","21"}};
        int maisVelho = 0;
        int maisNovo = 0;
        float mediaIdade = 0f;

        for(int i=0; i<matriz.length ; i++){
            int idade = Integer.parseInt(matriz[i][1]);
            if(idade > Integer.parseInt(matriz[maisVelho][1])){
                maisVelho = i;
            }
            if(idade < Integer.parseInt(matriz[maisNovo][1])){
                maisNovo = i;
            }
            mediaIdade += idade;
        }
        System.out.println("A pessoa mais nova é: "+ matriz[maisNovo][0]);
        System.out.println("A pessoa mais velha é: "+ matriz[maisVelho][0]);
        System.out.printf("A pessoa mais nova é: %.2f\n", mediaIdade/matriz.length);
    }
}
