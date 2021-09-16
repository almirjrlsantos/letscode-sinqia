package br.com.letscode.java.ativ2;

import java.util.Scanner;

public class Exerc3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.printf("Conversor de Celsius para Farenheit:\nInforme a temperatura em Celsius: ");
        float valor = scan.nextFloat();

        System.out.println(valor + "°C são " + ((valor * 9/5)+32) + "°F");
    }
}
