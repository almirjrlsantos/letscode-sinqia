package br.com.letscode.java.ativ2;

import java.util.Scanner;

public class Exerc1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.printf("Informe dois numeros inteiros: \nA: ");
        int valorA = scan.nextInt();
        System.out.printf("B: ");
        int valorB = scan.nextInt();

        System.out.println("\nResultados:");
        System.out.println("Soma: " + (valorA + valorB));
        System.out.println("Subtração: " + (valorA - valorB));
        System.out.println("Multiplicação: " + (valorA * valorB));
        System.out.println("Divisão: " + ((float) valorA / valorB));
        scan.close();
    }
}
