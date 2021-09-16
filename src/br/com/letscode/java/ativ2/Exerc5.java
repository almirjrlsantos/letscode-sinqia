package br.com.letscode.java.ativ2;

import java.util.Scanner;

public class Exerc5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.printf("Conversor de polegadas para centimetros:\nInforme a medida em polegadas: ");
        float valor = scan.nextFloat();

        System.out.printf("%.2fin são equivalentes a %.2fcm" , valor, valor*2.54);
    }
}
