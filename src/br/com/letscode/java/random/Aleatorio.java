package br.com.letscode.java.random;

import java.util.Random;

public class Aleatorio {
    public static void main(String[] args) {
        Random aleatorio = new Random();
        int[] numeros = new int[10];

        for(int i=0; i<numeros.length; i++){
            numeros[i] = aleatorio.nextInt(10);
            System.out.printf(numeros[i] + " - ");
        }
        System.out.println();
        for (int numero : numeros) {
            System.out.printf(numero + " - ");
        }
    }
}
