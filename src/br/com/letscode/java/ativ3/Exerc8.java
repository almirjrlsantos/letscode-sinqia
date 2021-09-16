//Escreva um programa que lê nome e peso de 5 pessoas, calcula o IMC de cada um e
// ao final informa se alguém está fora do peso ideal (o IMC ideal é entre 18,5 e 25).
package br.com.letscode.java.ativ3;

public class Exerc8 {
    public static void main(String[] args) {
        final float IMC_IDEAL_MIN = 18.5f;
        final float IMC_IDEAL_MAX = 25f;
        String[][] matriz = {{"Almir","80","1.70"},{"Meire","57.5","1.45"},{"Carol","55.3","1.62"},
                {"Rodrigo","95","1.68"},{"Fran","52","1.50"}};
        int[] foraImc = new int[matriz.length];

        int temp = 0;
        for(int i=0; i< matriz.length; i++){
            float peso = Float.parseFloat(matriz[i][1]);
            float altura = Float.parseFloat(matriz[i][2]);
            double calculo = peso/Math.pow(altura,2);
            if(calculo < IMC_IDEAL_MIN || calculo > IMC_IDEAL_MAX){
                foraImc[temp] = i;
                temp++;
            }
        }
        if(temp!=0){
            for(int i=0; i<temp; i++){
                System.out.printf("%s está fora do peso ideal\n", matriz[foraImc[i]][0]);
            }
        } else {
            System.out.println("Todos estão dentro do peso ideal, seguindo o padrão IMC");
        }
    }
}
