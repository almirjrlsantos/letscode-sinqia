//Escreva um programa que lê uma palavra e a escreve de volta ao contrário.
package br.com.letscode.java.ativ3;

import java.util.Arrays;

public class Exerc2 {
    public static void main(String[] args) {
        String palavra = "Palavra";
        System.out.printf("%s escrita ao contrário: ", palavra);
        String pInvertida = "";
        for (int i = palavra.length()-1; i >= 0; i--){
            pInvertida += palavra.charAt(i);
        }
        System.out.printf(pInvertida);
    }
}
