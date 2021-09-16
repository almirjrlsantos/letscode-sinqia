//Escreva um programa que lê 5 números. Ao final, escreva primeiros todos os ímpares, depois todos os pares.

package br.com.letscode.java.ativ3;

public class Exerc3 {
    public static void main(String[] args) {
        int[] numeros = {1,2,7,45,8};
        int[] pares = new int[numeros.length];
        int[] impares = new int[numeros.length];

        int flagPar = 0, flagImpar = 0;
        for(int i=0; i<numeros.length ; i++){
            if(numeros[i]%2==0){
                pares[flagPar] = numeros[i];
                flagPar++;
            } else {
                impares[flagImpar] = numeros[i];
                flagImpar++;
            }
        }
        System.out.println("Numeros impares: ");
        for(int i=0; i<flagImpar ; i++){
            System.out.println(impares[i]);
        }
        System.out.println(" ----- ");
        System.out.println("Numeros pares: ");
        for(int i=0; i<flagPar ; i++){
            System.out.println(pares[i]);
        }
    }

}
