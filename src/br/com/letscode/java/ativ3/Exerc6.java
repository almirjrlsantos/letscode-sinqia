//Escreva um programa que lê uma palavra e escreve de volta
// com os caracteres ímpares em maiúsculo.
package br.com.letscode.java.ativ3;

public class Exerc6 {
    public static void main(String[] args) {
        String palavra = "palavra";
        String palavraMaiuscula = palavra.toUpperCase();
        String palavraModif = "";

        for(int i=0; i<palavra.length(); i++){
            if(i%2==0){
                palavraModif += palavra.charAt(i);
            } else {
                palavraModif += palavraMaiuscula.charAt(i);
            }
        }
        System.out.println(palavraModif);
    }
}
