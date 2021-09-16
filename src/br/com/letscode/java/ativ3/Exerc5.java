//Escreva um programa que lê o nome de 5 pessoas e armazena numa lista de convidados.
// Ao final, informe qual o nome mais longo presente na lista.
package br.com.letscode.java.ativ3;

public class Exerc5 {
    public static void main(String[] args) {

        String[] convidados = new String[5];
        convidados[0] = "Almir";
        convidados[1] = "Meire";
        convidados[2] = "Carol";
        convidados[3] = "Rodrigo";
        convidados[4] = "Fran";

        int maior = 0;
        for(int i=0; i< convidados.length; i++){
            if(convidados[i].length()>convidados[maior].length()){
                maior = i;
            }
        }
        System.out.println("O maior nome da lista é "+ convidados[maior]);
    }
}
