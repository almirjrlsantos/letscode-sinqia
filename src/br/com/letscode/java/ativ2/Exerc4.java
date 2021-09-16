package br.com.letscode.java.ativ2;

import java.util.Scanner;

public class Exerc4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.printf("Informe a cotação do dólar: ");
        float dolar = scan.nextFloat();
        System.out.printf("Informe a quantidade em reais para conversão: ");
        float real = scan.nextFloat();

        System.out.printf("R$%.2f em dólares são US$%.2f.", real, (real/dolar));
    }
}
