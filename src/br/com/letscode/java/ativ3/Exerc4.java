//Escreva um programa que lê 5 números e informa o maior, o menor e a média deles.
package br.com.letscode.java.ativ3;

public class Exerc4 {
    public static void main(String[] args) {
        int[] numeros = {2,8,1,87,42};
        int maior = 0;
        int menor = 1000;
        float media = 0f;

        for(int i= 0; i<numeros.length ; i++){
            if(numeros[i]>maior){
                maior = numeros[i];
            }
            if(numeros[i]<menor){
                menor = numeros[i];
            }
            media+=numeros[i];
        }
        System.out.println("O maior número é o "+ maior);
        System.out.println("O menor número é o "+ menor);
        System.out.printf("A média é %.2f", media/numeros.length);
    }
}
