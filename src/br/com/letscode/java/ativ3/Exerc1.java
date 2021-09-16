//Escreva um programa que lê o nome de 5 frutas e armazena num carrinho de compras.
// Ao final da entrada dos 5 itens, exiba a lista completa.
package br.com.letscode.java.ativ3;

import java.util.Scanner;

public class Exerc1 {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        String[] carrinho = new String[5];

        System.out.println("Adicione 5 frutas ao carrinho: ");
        for (int i=0; i<carrinho.length ; i++){
            System.out.printf("%d: ", i+1);
            carrinho[i] = scan.nextLine();
        }
        System.out.println("Frutas adicionadas ao carrinho:");
        for(String fruta : carrinho){
            System.out.println(fruta);
        }


    }
}
